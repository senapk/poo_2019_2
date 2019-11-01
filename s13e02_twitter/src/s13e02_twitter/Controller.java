package s13e02_twitter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

class Repository<K, V>{
	String typename;
	Map<K, V> data = new TreeMap<K, V>();
	public Repository(String typename) {
		this.typename = typename;
	}
	
	boolean exists(K k) {
		return this.data.get(k) != null;
	}
	
	void add(K k, V t) {
		V value = this.data.get(k);
		if(value != null)
			throw new RuntimeException(this.typename + " " + k + " ja existe");
		this.data.put(k, t);
	}
	
	V get(K k) {
		V value = this.data.get(k);
		if(value == null)
			throw new RuntimeException(this.typename + " " + k + " nao existe");
		return value;
	}
	
	V remove(K k) {
		V value = this.data.remove(k);
		if(value == null)
			throw new RuntimeException(this.typename + " " + k + " nao existe");
		return value;
	}
	Collection<V> getAll(){
		return this.data.values();
	}
	public String toString() {
		String saida = "[ ";
		for(K key : this.data.keySet())
			saida += key + " ";
		return saida + "]";
	}
}

class Tweet{
	int id;
	String user;
	String message;
	TreeSet<String> likes;
	public Tweet(int id, String user, String message) {
		this.id = id;
		this.user = user;
		this.message = message;
		this.likes = new TreeSet<String>();
	}

	public String toString() {
		String saida = id + ":" + user + ":" + message + " [ ";
		for(String user : likes)
			saida += user + " ";
		return saida + "]";
	}
	public void darLike(String user) {
		this.likes.add(user);
	}
}

class User{
	static int nextId = 0;
	String login;
	Repository<String, User> seguidos;
	Repository<String, User> seguidores;
	List<Tweet> timeline;
	int unread = 0;
	public User(String login) {
		this.login = login;
		seguidos   = new Repository<String, User>("User");
		seguidores = new Repository<String, User>("User");
		timeline   = new ArrayList<Tweet>();
	}
	public String toString() {
		return login + "\n  seguidos  " + this.seguidos + "\n  seguidores" + seguidores;
	}
	public void seguir(User user) {
		if(seguidos.exists(user.login))
			return;
		seguidos.add(user.login, user);
		user.seguidores.add(this.login, this);
	}
	public void twittar(String message) {
		Tweet tweet = new Tweet(User.nextId, this.login, message);
		User.nextId += 1;
		this.timeline.add(tweet);
		for(User seguidor : seguidores.getAll()) {
			seguidor.timeline.add(tweet);
			seguidor.unread += 1;
		}
	}
	public String inbox() {
		String saida = "";
		for(int i = timeline.size() - unread; i < timeline.size(); i++)
			saida += timeline.get(i) + "\n";
		unread = 0;
		return saida;
	}
	public void darLike(int id) {
		for(Tweet tweet : this.timeline)
			if(tweet.id == id)
				tweet.darLike(this.login);
	}
}

class Service{
	private Repository<String, User> rUser;
	public Service() {
		rUser = new Repository<String, User>("Usuario");
	}
	public void addUser(String login) {
		rUser.add(login, new User(login));
	}
	public String toString() {
		String saida = "";
		for(User user : this.rUser.getAll())
			saida += user + "\n";
		return saida;
	}
	public User getUser(String login) {
		return rUser.get(login);
	}
	public String getInbox(String login) {
		return login + "\n" + rUser.get(login).inbox();
	}
}


public class Controller {
	public static void main(String[] args) {
		Service service = new Service();
		Scanner scanner = new Scanner(System.in);
		while(true) {
			String line = scanner.nextLine();
			String[] ui = line.split(" ");
			if(ui[0].contentEquals("end"))
				break;
			else if(ui[0].contentEquals("add"))
				service.addUser(ui[1]);
			else if(ui[0].contentEquals("show"))
				System.out.println(service);
			else if(ui[0].contentEquals("follow")) {
				User seguidor = service.getUser(ui[1]);
				for(int i = 2; i < ui.length; i++)
					seguidor.seguir(service.getUser(ui[i]));
			}else if(ui[0].contentEquals("twittar")) {//login messagem
				String message = "";
				for(int i = 2; i < ui.length; i++)
					message += ui[i] + " ";
				service.getUser(ui[1]).twittar(message);
			}else if(ui[0].contentEquals("inbox"))
				System.out.println(service.getInbox(ui[1]));
			else if(ui[0].contentEquals("like")) {
				service.getUser(ui[1]).darLike(Integer.parseInt(ui[2]));
			}
			else
				System.out.println("fail: comando invalido");
		}
		scanner.close();
	}
}

/*
 
 */






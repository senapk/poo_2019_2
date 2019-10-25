package s12e02_hospital;

import java.util.Collection;

public interface IMedico{
	public String getId();
	public void addPaciente(IPaciente paciente);
	public void removerPaciente(String idPaciente);
	public Collection<IPaciente> getPacientes();
}
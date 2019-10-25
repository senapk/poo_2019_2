package s12e02_hospital;

import java.util.Collection;
import java.util.Map;

class Medico implements IMedico{
	String id;
	Map<String, IPaciente> pacientes;
	public String getId() {
		return id;
	}
	public void addPaciente(IPaciente paciente) {
		IPaciente mpaciente = pacientes.get(paciente.getId());
		if(mpaciente != null)
			return;
		pacientes.put(paciente.getId(), paciente);
		paciente.addMedico(this);
	}
	public void removerPaciente(String idPaciente) {
		IPaciente mpaciente = pacientes.get(idPaciente);
		if(mpaciente == null)
			return;
		pacientes.remove(idPaciente);
		mpaciente.removerMedico(this.id);
	}
	public Collection<IPaciente> getPacientes(){
		return pacientes.values();
	}
}

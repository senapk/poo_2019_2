package s12e02_hospital;

import java.util.Map;

class Paciente{
	String id;
	Map<String, Medico> medicos;
	void addMedico(Medico medico) {
		Medico pmedico = medicos.get(medico.id);
		if(pmedico != null)
			return;
		medicos.put(medico.id, medico);
		medico.addPaciente(this);
	}
	
}
class Medico{
	String id;
	Map<String, Paciente> pacientes;
	void addPaciente(Paciente paciente) {
		Paciente mpaciente = pacientes.get(paciente.id);
		if(mpaciente != null)
			return;
		pacientes.put(paciente.id, paciente);
		paciente.addMedico(this);
	}
}

class Hospital{
	Map<String, Paciente> pacientes;
	Map<String, Medico> medicos;
}

public class Controller {

}

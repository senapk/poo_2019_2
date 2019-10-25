package s12e02_hospital;

import java.util.Map;

class class Hospital{
	Map<String, IPaciente> pacientes;
	Map<String, IMedico> medicos;
	
	void removerPaciente(String id) {
		IPaciente paciente = pacientes.get(id);
		if(paciente == null)
			return;
		for(IMedico medico : paciente.getMedicos()) 
			medico.removerPaciente(id);
		pacientes.remove(id);
	}
	void removerMedico(String id) {
		IMedico medico = medicos.get(id);
		if(medico == null)
			return;
		for(IPaciente paciente : medico.getPacientes()) 
			paciente.removerMedico(id);
		medicos.remove(id);
	}
}

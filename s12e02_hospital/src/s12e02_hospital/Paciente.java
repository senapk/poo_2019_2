package s12e02_hospital;

import java.util.Collection;
import java.util.Map;

public class Paciente implements IPaciente{
	protected String id;
	protected Map<String, IMedico> medicos;
	public String getId() {
		return id;
	}
	public void addMedico(IMedico medico) {
		IMedico pmedico = medicos.get(medico.getId());
		if(pmedico != null)
			return;
		medicos.put(medico.getId(), medico);
		medico.addPaciente(this);
	}
	public void removerMedico(String idMedico) {
		IMedico pmedico = medicos.get(idMedico);
		if(pmedico == null)
			return;
		medicos.remove(idMedico);
		pmedico.removerPaciente(this.id);
	}
	public Collection<IMedico> getMedicos(){
		return medicos.values();
	}

}
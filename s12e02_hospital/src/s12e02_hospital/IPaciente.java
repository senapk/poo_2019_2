package s12e02_hospital;

import java.util.Collection;

public interface IPaciente{
	public String getId();
	public void addMedico(IMedico medico);
	public void removerMedico(String idMedico);
	public Collection<IMedico> getMedicos();
}
package models;

public class UsuarioDao extends Dao<Usuario>{
    public UsuarioDao() {
        super(Usuario.class);
    }
    
    public Usuario getByEmailAndSenha(String usuario, String senha) {
        super.newCriteria();
        return super.criteria.andStringLike("usuario", usuario).andStringLike("senha", senha).getSingleResult();
    }
    
}

package model.bean;

public class Usuario {
    private int id;
    private String login, senha;

    public Usuario(){}
    public Usuario(String login){ setLogin(login); }
    public Usuario(String login, String senha){setLogin(login); setSenha(senha);}
    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    @Override
    public String toString() {
        return "Usuario{" + "id=" +id+ ", login=" +login+ ", senha=" +senha+ '}'; }
}

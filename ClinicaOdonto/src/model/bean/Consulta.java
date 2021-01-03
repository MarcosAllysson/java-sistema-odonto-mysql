/*Composição: criar atributo do tipo de outra classe;
SQL. Exemplo: stmt.setInt(column, consulta.getUsuario().getId()); */
package model.bean;

public class Consulta {
    private String nome, dataNascimento, telefone, celular, cpf, sexo, dataConsulta, pagamento, consulta, email;
    private int id;
    private double total;
    private Usuario usuario;
    
    public Consulta(){}
    
    public Consulta(int id, String nome, String telefone, String celular){
        setId(id);
        setNome(nome);
        setTelefone(telefone);
        setCelular(celular); }

    public Consulta(String nome, String dataNascimento, String telefone, String celular, String cpf, String sexo, String dataConsulta,
            String pagamento, String consulta, String email, double total) {
        setNome(nome);
        setDataNascimento(dataNascimento);
        setTelefone(telefone);
        setCelular(celular);
        setCpf(cpf);
        setSexo(sexo);
        setDataConsulta(dataConsulta);
        setPagamento(pagamento);
        setConsulta(consulta);
        setEmail(email);
        setTotal(total); }
    
    public Usuario getUsuario() { return usuario; }
    public void setUsuario() { this.usuario = usuario; }
    
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getCelular() { return celular; }
    public void setCelular(String celular) { this.celular = celular; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf;}

    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }

    public String getDataConsulta() { return dataConsulta; }
    public void setDataConsulta(String dataConsulta) { this.dataConsulta = dataConsulta; }

    public String getPagamento() { return pagamento; }
    public void setPagamento(String pagamento) { this.pagamento = pagamento; }

    public String getConsulta() { return consulta; }
    public void setConsulta(String consulta) { this.consulta = consulta; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(String dataNascimento) { this.dataNascimento = dataNascimento; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    @Override
    public String toString() {
        return "Consulta{" + "nome=" +nome+ ", telefone=" +telefone+ ", celular=" +celular+ ", cpf=" +cpf+ 
        ", sexo=" +sexo+ ", dataConsulta=" +dataConsulta+ ", pagamento=" +pagamento+ ", consulta=" +consulta+ 
        ", email=" +email+ ", dataNascimento=" +dataNascimento+ ", id=" +id+ ", total=" +total+ '}';
    }
}

public class Livro
{
    
    private String titulo; //
    private String autor;
    private String ISBN; //International Standard Book Number
    private boolean emprestado;

    public Livro(String titulo, String autor, String ISBN)
    {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.emprestado = false;
    }
    
    public Livro(String titulo, String autor)
    {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = "";
        this.emprestado = false;
    }
    
    public String getTitulo(){
        return this.titulo;
    }
    
    public String getAutor(){
        return this.autor;
    }
    
    public String getISBN(){
        return this.ISBN;
    }
    
    public boolean isEmprestado(){
        return this.emprestado;
    }
    
    private void setEmprestado(boolean isEmprestado){
        this.emprestado = isEmprestado;
    }

    public boolean reservar(){
        boolean livroEstaEmprestado = this.isEmprestado();
        
        if (livroEstaEmprestado){
            return false; //Se está emprestado, não pode ser reservado.
        } else {
            this.setEmprestado(true); //Define como emprestado
            return true;                //Retorna sucesso.
        }
        
    }
    
    public boolean devolver(){
        boolean livroEstaEmprestado = this.isEmprestado();
        
        if (livroEstaEmprestado){ //Verifica se está emprestado
            this.setEmprestado(false); //Se sim, devolve.
            return true;
        } else {
            return false; //Não está emprestado.
        }
    }
    
    public String exibir_info(){
        String informacoes = 
            "Título: " + this.getTitulo() +
            ", Autor: " + this.getAutor();
            
        String ISBN = this.getISBN();
        
        if (ISBN != ""){
            informacoes = informacoes + ", ISBN: " + ISBN;
        }
        
        
        boolean livroEmprestado = this.isEmprestado();
        if (livroEmprestado){
            informacoes = informacoes + " (Emprestado)";
        } else {
            informacoes = informacoes + " (Disponível)";
        }
        
        return informacoes;
        
    }
}
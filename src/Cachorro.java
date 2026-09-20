public class Cachorro extends Animal {

    public Cachorro(long id, String nome, int idade, double peso) {
        super(id, nome, idade, peso);
        this.getHabilidades().add("farejar");
    }

    @Override
    public String emitirSom() {
        return "au";
    }
}

import java.util.ArrayList;

public class Zoologico {

    private ArrayList<Animal> animais;

    public Zoologico() {
        this.animais = new ArrayList<>();
    }

    public boolean adicionarAnimal(Animal animal) {
        if (buscarAnimal(animal.getId()) != null) {
            return false;
        }
        animais.add(animal);
        return true;
    }

    public ArrayList<Animal> listarAnimais() {
        return animais;
    }

    public Animal buscarAnimal(long id) {
        for (Animal animal : animais) {
            if (animal.getId() == id) {
                return animal;
            }
        }
        return null;
    }

    public boolean removerAnimal(long id) {
        Animal animal = buscarAnimal(id);
        if (animal != null) {
            animais.remove(animal);
            return true;
        }
        return false;
    }
}

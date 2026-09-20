import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Zoologico zoologico = new Zoologico();
        int opcao;

        do {
            System.out.println("\n===== MENU ZOOLOGICO =====");
            System.out.println("1. Adicionar animal");
            System.out.println("2. Listar todos os animais");
            System.out.println("3. Remover animal");
            System.out.println("4. Emitir som de um animal");
            System.out.println("5. Testar habilidade de um animal");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opcao: ");

            opcao = lerInteiro(scanner);

            switch (opcao) {
                case 1:
                    adicionarAnimal(scanner, zoologico);
                    break;
                case 2:
                    listarAnimais(zoologico);
                    break;
                case 3:
                    removerAnimal(scanner, zoologico);
                    break;
                case 4:
                    emitirSom(scanner, zoologico);
                    break;
                case 5:
                    testarHabilidade(scanner, zoologico);
                    break;
                case 6:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }

        } while (opcao != 6);

        scanner.close();
    }

    private static void adicionarAnimal(Scanner scanner, Zoologico zoologico) {
        System.out.println("Escolha o tipo de animal:");
        System.out.println("1. Gato");
        System.out.println("2. Cachorro");
        System.out.println("3. Passaro");
        System.out.print("Tipo: ");
        int tipo = lerInteiro(scanner);

        if (tipo < 1 || tipo > 3) {
            System.out.println("Tipo invalido!");
            return;
        }

        System.out.print("ID: ");
        long id = lerLong(scanner);

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Idade: ");
        int idade = lerInteiro(scanner);

        System.out.print("Peso: ");
        double peso = lerDouble(scanner);

        Animal animal;
        switch (tipo) {
            case 1:
                animal = new Gato(id, nome, idade, peso);
                break;
            case 2:
                animal = new Cachorro(id, nome, idade, peso);
                break;
            default:
                animal = new Passaro(id, nome, idade, peso);
                break;
        }

        boolean sucesso = zoologico.adicionarAnimal(animal);
        if (sucesso) {
            System.out.println("Animal adicionado com sucesso!");
        } else {
            System.out.println("Ja existe um animal com esse ID!");
        }
    }

    private static void listarAnimais(Zoologico zoologico) {
        if (zoologico.listarAnimais().isEmpty()) {
            System.out.println("Nenhum animal cadastrado.");
            return;
        }
        System.out.println("\n--- Lista de Animais ---");
        for (Animal animal : zoologico.listarAnimais()) {
            System.out.println(animal);
        }
    }

    private static void removerAnimal(Scanner scanner, Zoologico zoologico) {
        System.out.print("ID do animal a remover: ");
        long id = lerLong(scanner);
        boolean removido = zoologico.removerAnimal(id);
        System.out.println("Animal removido: " + removido);
    }

    private static void emitirSom(Scanner scanner, Zoologico zoologico) {
        System.out.print("ID do animal: ");
        long id = lerLong(scanner);
        Animal animal = zoologico.buscarAnimal(id);
        if (animal != null) {
            System.out.println(animal.getNome() + " diz " + animal.emitirSom());
        } else {
            System.out.println("Animal nao encontrado.");
        }
    }

    private static void testarHabilidade(Scanner scanner, Zoologico zoologico) {
        System.out.print("ID do animal: ");
        long id = lerLong(scanner);
        Animal animal = zoologico.buscarAnimal(id);
        if (animal == null) {
            System.out.println("Animal nao encontrado.");
            return;
        }
        System.out.print("Habilidade a testar: ");
        String habilidade = scanner.nextLine();
        System.out.println(animal.realizarHabilidade(habilidade));
    }

    private static int lerInteiro(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Valor invalido, digite um numero inteiro: ");
            scanner.next();
        }
        int valor = scanner.nextInt();
        scanner.nextLine();
        return valor;
    }

    private static long lerLong(Scanner scanner) {
        while (!scanner.hasNextLong()) {
            System.out.print("Valor invalido, digite um numero inteiro: ");
            scanner.next();
        }
        long valor = scanner.nextLong();
        scanner.nextLine();
        return valor;
    }

    private static double lerDouble(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.print("Valor invalido, digite um numero: ");
            scanner.next();
        }
        double valor = scanner.nextDouble();
        scanner.nextLine();
        return valor;
    }
}

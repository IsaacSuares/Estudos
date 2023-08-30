import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

public class Gato implements Serializable {
    String name;
    String cor;
    int idade;
    int patas;
    double peso;
    transient long secretPassword;

    Gato(String name, String cor, int idade, int patas, double peso, long secretPassword){
        this.name = name;
        this.cor = cor;
        this.idade = idade;
        this.patas = patas;
        this.peso = peso;
        this.secretPassword = secretPassword;
    }

    @Override
    public String toString() {
        return "Gato{" +
                "name='" + name + '\'' +
                ", cor='" + cor + '\'' +
                ", idade=" + idade +
                ", patas=" + patas +
                ", peso=" + peso +
                ", SecretPassword=" + secretPassword +
                '}';
    }

}

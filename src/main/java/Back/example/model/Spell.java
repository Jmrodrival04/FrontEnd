package Back.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Spell {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private String effect;
    private int level; // Nivel de intensidad del hechizo

    // Constructor sin argumentos requerido por JPA
    public Spell() {
    }

    // Constructor completo
    public Spell(Long id, String name, String type, String effect, int level) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.effect = effect;
        this.level = level;
    }

    // Constructor personalizado para crear un nuevo hechizo
    public Spell(String name, String type, String effect, int level) {
        this.name = name;
        this.type = type;
        this.effect = effect;
        this.level = level;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    // Método toString para depuración
    @Override
    public String toString() {
        return "Spell{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", effect='" + effect + '\'' +
                ", level=" + level +
                '}';
    }
}

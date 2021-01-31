package pl.transmar.budowa.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Machines")
public class Machine {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MachineID")
    private long machineId;
    @OneToOne
    @JoinColumn(name = "PersonID")
    private Person person;
    @Column(name = "Name", unique = true, nullable = false)
    private String name;
    @Column(name = "Type", nullable = false)
    private MachineType type;



    public Machine(String name, MachineType type, Person person) {
        this.name = name;
        this.type = type;
        this.person = person;
    }

    @Override
    public String toString() {
        return name;
    }
}

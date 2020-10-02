package pl.transmar.budowa.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
@JsonIgnoreProperties(ignoreUnknown = true)
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


    public Machine() {
    }

    public Machine(String name, MachineType type, Person person) {
        this.name = name;
        this.type = type;
        this.person = person;
    }

    public long getMachineId() {
        return machineId;
    }

    public void setMachineId(long machineId) {
        this.machineId = machineId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MachineType getType() {
        return type;
    }

    public void setType(MachineType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return name;
    }
}

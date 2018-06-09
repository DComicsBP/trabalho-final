package br.edu.restinga.dev.daione.pavan.Petshop.Petshop.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID; 
    private int IDPet; 
    private int IDVeterinario; 
    private String Motivo; 
    private String prescricao; 
    private String medicacaoUsada; 
    private double valorTotal;  
    private int procedimento;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getIDPet() {
        return IDPet;
    }

    public void setIDPet(int IDPet) {
        this.IDPet = IDPet;
    }

    public int getIDVeterinario() {
        return IDVeterinario;
    }

    public void setIDVeterinario(int IDVeterinario) {
        this.IDVeterinario = IDVeterinario;
    }

    public String getMotivo() {
        return Motivo;
    }

    public void setMotivo(String Motivo) {
        this.Motivo = Motivo;
    }

    public String getPrescricao() {
        return prescricao;
    }

    public void setPrescricao(String prescricao) {
        this.prescricao = prescricao;
    }

    public String getMedicacaoUsada() {
        return medicacaoUsada;
    }

    public void setMedicacaoUsada(String medicacaoUsada) {
        this.medicacaoUsada = medicacaoUsada;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(int procedimento) {
        this.procedimento = procedimento;
    }
    
    
}

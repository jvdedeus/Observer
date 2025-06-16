package org.example;

import java.util.Observable;

public class ControleUpload extends Observable {
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void concluirUpload(){
        setStatus("Concluído");
        setChanged();
        notifyObservers();
    }

    public void cancelarUpload(){
        setStatus("Cancelado");
        setChanged();
        notifyObservers();
    }

    public void pausarUpload(){
        setStatus("Pausado");
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return status;
    }
}

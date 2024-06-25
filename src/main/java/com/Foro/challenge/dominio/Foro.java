package com.Foro.challenge.dominio;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name = "foros")
@Entity(name = "Foro")
@Getter
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Foro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private String autor;
    private String curso;
    private Boolean status;

    @Column(name = "fecha_registro")
    private LocalDate fechaCreacion;

    public Foro(DatosForo Datosforo) {
        this.titulo=Datosforo.titulo();
        this.mensaje=Datosforo.mensaje();
        this.autor=Datosforo.autor();
        this.curso=Datosforo.curso();
        this.status=true;
        this.fechaCreacion=LocalDate.now();
    }
    public Foro(){}

    @Override
    public String toString() {
        return "Foro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", mensaje='" + mensaje + '\'' +
                ", autor='" + autor + '\'' +
                ", curso='" + curso + '\'' +
                ", status=" + status +
                ", fechaCreacion=" + fechaCreacion +
                '}';
    }

    public void actulizarDatos(DTOActualizacion actualizacion) {
        if (actualizacion.titulo()!=null){
            this.titulo=actualizacion.titulo();
        }
        if (actualizacion.mensaje()!=null){
            this.mensaje=actualizacion.mensaje();
        }
        if (actualizacion.autor()!=null){
            this.autor=actualizacion.autor();
        }
        if (actualizacion.curso()!=null){
            this.curso=actualizacion.curso();
        }
    }

    public void eliminar() {
        this.status=false;
    }
}

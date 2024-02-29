package com.genericAPI.models;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="users")
public class UserModel {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, unique = true, nullable = false)
	private UUID id;
    
    @Column(nullable = false, length = 32)
    @NotBlank(message = "Campo de apelido nulo ou vazio")
    @Size(max = 32, message="Campo de apelido até 32 caracteres")
    String apelido;
    
    @Column(nullable = false, length = 100)
    @NotBlank(message = "Campo de nome nulo ou vazio")
    @Size(max = 100,message = "Campo de nome até 100 caracteres")
    String nome;
    
    @Column(nullable = false, length = 10 )
    @Pattern(regexp = "\\d{4}\\-\\d{2}\\-\\d{2}", message = "Formato de data deve ser AAAA-MM-DD")
    @NotBlank(message = "Campo de nascimento nulo ou vazio")
    String nascimento;
    
    @Column(nullable = true)
    List<
        @NotBlank(message = "Elemento de stack nulo ou vazio")
        @Size(max = 32, message = "Elemento de stack até 32 caracteres")
        String
    > stack;
}
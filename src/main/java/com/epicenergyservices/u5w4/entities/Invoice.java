package com.epicenergyservices.u5w4.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "invoices")
public class Invoice {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Setter(AccessLevel.NONE)
  @Column(updatable = false, nullable = false)
  private UUID id;

  @Column(nullable = false)
  private LocalDate date;

  @Column(nullable = false)
  private double amount;

  @Column(nullable = false)
  private String status;

  @ManyToOne
  @JoinColumn(name = "client_id", referencedColumnName = "id")
  private Client client;

  public Invoice(LocalDate date, double amount, String status, Client client) {
    this.date = date;
    this.amount = amount;
    this.status = status;
    this.client = client;
  }
}

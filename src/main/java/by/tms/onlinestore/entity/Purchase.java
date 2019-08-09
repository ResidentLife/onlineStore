package by.tms.onlinestore.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "PURCHASES")
public class Purchase {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PERSON_ID", nullable = false)
    private Person person;

    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    @Column(name = "DATETIME")
    private LocalDateTime dateTime;

    @Column(name = "COST")
    private BigDecimal cost;

    @Column(name = "AMOUNT")
    private int amount;

    public Purchase() {
    }

    public Purchase(Person person, Item item, LocalDateTime dateTime, int amount) {
        this.person = person;
        this.item = item;
        this.dateTime = dateTime;
        this.cost = item.getPrice().multiply(new BigDecimal(amount).setScale(0, RoundingMode.CEILING));
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @NotNull
    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return amount == purchase.amount &&
                Objects.equals(id, purchase.id) &&
                Objects.equals(person, purchase.person) &&
                Objects.equals(item, purchase.item) &&
                Objects.equals(dateTime, purchase.dateTime) &&
                Objects.equals(cost, purchase.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, person, item, dateTime, cost, amount);
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", person=" + person +
                ", item=" + item +
                ", dateTime=" + dateTime +
                ", cost=" + cost +
                ", amount=" + amount +
                '}';
    }
}

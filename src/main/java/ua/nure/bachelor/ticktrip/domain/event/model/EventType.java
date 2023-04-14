package ua.nure.bachelor.ticktrip.domain.event.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "event_type")
@Getter
@Setter
@NoArgsConstructor
public class EventType {

    @Id
    @NotNull
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "typeName")
    private Set<Event> events = new HashSet<>();
}

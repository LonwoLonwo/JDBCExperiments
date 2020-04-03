import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Subscriptions")
public class Subscription {
    @EmbeddedId
    SubscriptionPKey personalKey;
}

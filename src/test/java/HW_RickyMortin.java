import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jsonObjects.HW.Result;
import jsonObjects.HW.Root;
import Rest.Rest;
import org.junit.Test;
public class HW_RickyMortin {
    @Test
    public void testAllCharacters() throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        Root episodes = om.readValue(Rest.getRest("https://rickandmortyapi.com/api/episode"), Root.class);
        do {
            for (Result l : episodes.results) {
                System.out.println(l.name + " - " + l.air_date);
            }
            if (episodes.info.next != null) {

                episodes = om.readValue(Rest.getRest(episodes.info.next), Root.class);
            }
        } while (episodes.info.next != null);
    }
}

package challenge;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class JogadorService {

    private List<Jogador> jogadores = new ArrayList<>();


    public JogadorService() {

        try {
            carregarDados();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void carregarDados() throws FileNotFoundException {

        FileReader leitor = abrirArquivo();

        jogadores = new CsvToBeanBuilder(leitor)
                .withType(Jogador.class)
                .build()
                .parse();
    }

    private FileReader abrirArquivo() throws FileNotFoundException {

        URL url = getClass().getClassLoader().getResource("data.csv");

        if (url == null)
            return null;

        return new FileReader(url.getFile());
    }

    public int q1() {
        return (int) jogadores
                .stream()
                .map(Jogador::getNationality)
                .distinct()
                .count();
    }

    public int q2() {
        return (int) jogadores
                .stream()
                .filter(j -> !(j.getClub().isEmpty()))
                .map(Jogador::getClub)
                .distinct()
                .count();
    }

    public List<String> q3() {
        return jogadores
                .stream()
                .limit(20)
                .map(Jogador::getFullName)
                .collect(Collectors.toList());
    }

    public List<String> q4() {
        return jogadores
                .stream()
                .filter(j -> j.getEurReleaseClause() != null)
                .sorted(Comparator.comparingDouble(Jogador::getEurReleaseClause).reversed())
                .limit(10)
                .map(Jogador::getFullName)
                .collect(Collectors.toList());
    }

    public List<String> q5() {

        Comparator<Jogador> comparator = Comparator.comparing(Jogador::getBirthDate)
                .thenComparingDouble(Jogador::getEurWage);

        return jogadores.stream()
                .sorted(comparator)
                .limit(10)
                .map(Jogador::getFullName)
                .collect(Collectors.toList());
    }

    public Map<Integer, Integer> q6() {

        //collection pra fazer count retornando Integer (requisito do desafio)
        // pois o Collectors.counting() retorna Long
        Collector<Object, ?, Integer> contador = Collectors.reducing(0, e -> 1, Integer::sum);

        return jogadores.stream()
                .sorted(Comparator.comparingInt(Jogador::getAge))
                .collect(Collectors.groupingBy(Jogador::getAge, contador));
    }
}

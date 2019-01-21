package challenge;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

import java.util.Date;

public class Jogador {

    @CsvBindByName(column = "ID")
    private String id;

    @CsvBindByName(column = "name")
    private String name;

    @CsvBindByName(column = "full_name")
    private String fullName;

    @CsvBindByName(column = "nationality")
    private String nationality;

    @CsvBindByName(column = "club")
    private String club;

    @CsvBindByName(column = "eur_release_clause")
    private Double eurReleaseClause;

    @CsvBindByName(column = "eur_wage")
    private Double eurWage;

    @CsvBindByName(column = "birth_date")
    @CsvDate("yyyy-MM-dd")
    private Date birthDate;

    @CsvBindByName(column = "age")
    private Integer age;

    public Jogador() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public Double getEurReleaseClause() {
        return eurReleaseClause;
    }

    public void setEurReleaseClause(Double eurReleaseClause) {
        this.eurReleaseClause = eurReleaseClause;
    }

    public Double getEurWage() {
        return eurWage;
    }

    public void setEurWage(Double eurWage) {
        this.eurWage = eurWage;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", nationality='" + nationality + '\'' +
                ", club='" + club + '\'' +
                ", eurReleaseClause=" + eurReleaseClause +
                ", eurWage=" + eurWage +
                ", birthDate=" + birthDate +
                ", age=" + age +
                '}';
    }
}

public class Candidate_Chan {
    public String name, degree;
    public String ID;
    public String phone;
    //constructor
    public Candidate_Chan(String name, String ID, String phone, String degree){
        this.name = name;
        this.ID = ID;
        this.phone = phone;
        this.degree = degree;
    }
    public Candidate_Chan(){

    }
    //accessors
    public String getName() {
        return name;
    }
    public String getID() {
        return ID;
    }
    public String getPhone() {
        return phone;
    }
    public String getDegree() {
        return degree;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Candidate_Chan deepCopy(){
        Candidate_Chan clone = new Candidate_Chan(name, ID, phone, degree);
        return clone;
    }
    public String toString() {
        String str = String.format("%-20s %10s", "Name:", getName() + "\n");
        str += String.format("%-20s %10s", "ID:", getID() + "\n");
        str += String.format("%-20s %10s", "Phone:", getPhone() + "\n");
        str += String.format("%-20s %10s", "Degree:", getDegree() + "\n");
        return str;
    }
    public String fileString(){//method to prepare the string for importing to file
        String str = getName()+"-"+getID()+"-"+getPhone()+"-"+getDegree();
        return str;
    }
    public int compareTo(String targetKey){
        return (ID.compareTo(targetKey));
    }
}

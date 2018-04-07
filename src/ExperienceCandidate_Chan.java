public class ExperienceCandidate_Chan extends Candidate_Chan {
    private int expYear;
    private double lastSalary;
    //constructor
    public ExperienceCandidate_Chan(String name, String ID, String phone, String degree, int expYear, double lastSalary){
        super(name, ID, phone, degree);
        this.expYear = expYear;
        this.lastSalary = lastSalary;
    }
    //accessor
    public int getExpYear() {
        return expYear;
    }
    public double getLastSalary() {
        return lastSalary;
    }
    public ExperienceCandidate_Chan deepCopy(){
        ExperienceCandidate_Chan clone = new ExperienceCandidate_Chan(name, ID, phone, degree, expYear, lastSalary);
        return clone;
    }
    public String toString() {
        String str1 = super.toString();
        str1 += String.format("%-20s %10s", "Experience Year:", getExpYear() + "\n");
        str1 += String.format("%-20s %10.2f", "Last Salary:", getLastSalary());
        str1 += "\n";
        return str1;
    }
    public String fileString(){
        String str = super.fileString();
        str += "-"+getExpYear()+"-"+getLastSalary();
        return str;
    }
}

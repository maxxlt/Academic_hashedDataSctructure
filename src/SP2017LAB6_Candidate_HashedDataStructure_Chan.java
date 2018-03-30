public class SP2017LAB6_Candidate_HashedDataStructure_Chan {
    public static void main(String[] args) {
        LQHashed_Chan testStruct = new LQHashed_Chan(10000);
        Candidate_Chan test = new Candidate_Chan("Max", "3162608", 3176192, "Bachelor's Degree");
        testStruct.insert(test);
    }
}

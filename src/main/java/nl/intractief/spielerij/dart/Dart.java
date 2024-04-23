package nl.intractief.spielerij.dart;


record Dart(int score, type type) {

}

enum type {
    SINGLE,
    DOUBLE,
    TRIPLE;

    Dart dart(int score) {
        return new Dart(score,this);
    }
}

record Turn(Dart first,Dart second, Dart third) {

};
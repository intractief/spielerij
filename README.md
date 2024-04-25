# Dart opdracht

Bereken hoeveel verschillende manier je kan uitgooien vanaf score 90.

De opdracht begint in [DartScoreTest](src/test/java/nl/intractief/spielerij/dart/DartScoreTest.java)

### Dart uitleg

![Dartboard!](Dartboard.svg)

Een [dartbord](https://nl.m.wikipedia.org/wiki/Darts_(sport)) bestaat uit 20 taartpunten die onderverdeeld zijn in ringen.
- Elke punt heeft een basiscore (1 tot 20)
- De buitenste ring telt dubbel
- De middelste ring telt driedubbel
- Buiten de ringen telt enkel
- In het midden zit de bulsseye (buitenste ring is 25, binnenste is 50)
- Uitgooien moet met een dubbel.

### Setup

Voor lokaal

* install https://sdkman.io
* `sdk i java 21.0.3-tem`
* `sdk install maven`
* gebruik https://www.jetbrains.com/idea/ of https://code.visualstudio.com

run tests (of gebruik de IDE run options)

```bash
mvn verify
```
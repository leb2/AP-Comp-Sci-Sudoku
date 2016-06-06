JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
		  Cell.java \
		  Grid.java \
		  Square.java \
		  SudokuBoard.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class

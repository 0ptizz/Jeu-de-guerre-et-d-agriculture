JAVA_SRC = actions/ActionsArmy.java \
		   actions/ActionsGlobal.java \
		   actions/ActionsWorker.java \
		   board/Board.java \
		   board/tile/Case.java \
		   board/tile/Desert.java \
		   board/tile/Forest.java \
		   board/tile/Mountains.java \
		   board/tile/Plain.java \
		   board/tile/Sea.java \
		   Game.java \
		   ArmyGame.java \
		   WorkerGame.java \
		   MainWorkerGame.java \
		   MainArmyGame.java \
		   player/ArmyPlayer.java \
		   player/Player.java \
		   player/WorkerPlayer.java \
		   units/ArmyUnit.java \
		   units/Unit.java \
		   units/WorkerUnit.java \
		   util/Ressources.java

CLASSES = $(JAVA_SRC:.java=.class)

clean:
	rm -rf classes doc manifest.mf jar

doc:
	cd src; \
	javadoc $(JAVA_SRC) -d ../doc; \
	cd ..

guerre.jar:
	make cls
	@echo "Main-Class: MainArmyGame" > manifest.mf
	jar cvfm jar/guerre.jar manifest.mf -C classes/ .

agricole.jar:
	make cls
	@echo "Main-Class: MainWorkerGame" > manifest.mf
	jar cvfm jar/agricole.jar manifest.mf -C classes/ .

cls: 
	cd src ;\
	javac $(JAVA_SRC) -d ../classes ;\
	cd ..




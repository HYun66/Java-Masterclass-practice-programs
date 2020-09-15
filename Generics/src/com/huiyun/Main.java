package com.huiyun;

public class Main {

    public static void main(String[] args) {
	    FootballPlayer joe = new FootballPlayer("Joe");
	    BaseballPlayer pat = new BaseballPlayer("Pat");
	    SoccerPlayer beckham = new SoccerPlayer("Beckham");

	    Team<FootballPlayer> auCrows = new Team("Australia Crows");
	    auCrows.addPlayer(joe);

        Team<FootballPlayer> footballPlayerTeam = new Team("Au Star");

        Team<BaseballPlayer> baseballTeam = new Team("Chicago cubs");
        baseballTeam.addPlayer(pat);

        Team<SoccerPlayer> soccerTeam = new Team("Machester");
        soccerTeam.addPlayer(beckham);

        System.out.println(auCrows.numPlayers());

        auCrows.matchResult(footballPlayerTeam, 1, 0);
        System.out.println("Ranking: ");
        System.out.println(auCrows.getName() + ": " + auCrows.ranking());
        System.out.println(auCrows.compareTo(footballPlayerTeam));
    }
}

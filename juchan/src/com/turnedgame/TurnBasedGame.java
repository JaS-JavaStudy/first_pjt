package com.turnedgame;

import java.io.*;
import java.util.Random;

public class TurnBasedGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 영웅과 몬스터 이름 입력
        System.out.println("영웅의 이름을 입력하세요:");
        String heroname = br.readLine();
        System.out.println("몬스터의 이름을 입력하세요:");
        String monstername = br.readLine();

        // 영웅과 몬스터 생성 (이름만 입력)
        Character hero = new Character(heroname);
        Character monster = new Character(monstername);

        // 캐릭터 정보 출력
        System.out.println("=== 캐릭터 정보 ===");
        System.out.println(hero.name + " - 속성: " + hero.element + ", 공격력: " + hero.attackPower + ", 마나: " + hero.mana);
        System.out.println(monster.name + " - 속성: " + monster.element + ", 공격력: " + monster.attackPower + ", 마나: " + monster.mana);
        System.out.println();

        // 전투 시뮬레이션
        while (hero.isAlive() && monster.isAlive()) {
            // 영웅의 턴
            System.out.println("===== " + hero.name + "의 턴 =====");
            System.out.println("1. 스킬 공격하기 2. 일반 공격하기");
            String choice = br.readLine();

            if ("1".equals(choice)) {
                hero.heroUseSkill(monster);
            } else if ("2".equals(choice)) {
                hero.heroBasicAttack(monster);
            }

            if (!monster.isAlive()) {
                System.out.println("몬스터가 쓰러졌습니다!");
                System.out.println(hero.getRandomEndingHeroDialogue());
                break;
            }

            System.out.println("==== 턴 종료 ====");  // 턴 종료 메시지

            // 몬스터의 턴
            System.out.println("===== " + monster.name + "의 턴 =====");
            int monsterChoice = new Random().nextInt(2) + 1;
            if (monsterChoice == 1 && monster.mana >= monster.skillManaCost) {
                monster.monsterUseSkill(hero);
            } else {
                monster.monsterBasicAttack(hero);
            }

            if (!hero.isAlive()) {
                System.out.println("영웅이 쓰러졌습니다...");
                System.out.println(monster.getRandomEndingMonsterDialogue());
                break;
            }

            System.out.println("==== 턴 종료 ====");  // 턴 종료 메시지
        }

        br.close();
    }
}

package com.turnedgame;

import java.util.Random;

enum Element {
    WATER, FIRE, EARTH, LIGHTNING, WOOD
}

public class Character {
    String name;
    int health;
    int attackPower;
    int mana;
    Element element;
    int skillPower;
    int skillManaCost;

    private static final String[] opponentHitDialogues = {
            "크큭 가소롭군..",
            "인간 주제에 제법이군...",
            "그 정도로는 나에게 상처를 줄 수 없다"
    };

    private static final String[] selfHitDialogues = {
            "이 정도로는 우리를 쓰러트릴 수 없어!",
            "그 정도로는 신성한 내 갑옷에 기스 조차 낼 수 없다!",
    };

    private static final String[] heroAttackDialogues = {
            "받아라! 정의의 엑.스.칼.리.버",
            "모두 나에게 힘을!! 이것이 인간의 검이다...!",
            "모두의 염원을 담아.. 일.도.양.단...!"
    };

    private static final String[] monsterAttackDialogues = {
            "몽둥이 휘두르기",
            "받아라 이것이 사천왕의 힘이다..!",
            "어둠의 힘을 감당해봐라..!"
    };

    private static final String[] endingHeroDialogues = {
            "이것이 인간들의 힘이다.",
            "정의의 엑스칼리버로 오늘도 세계를 지켜냈다",
            "우리의 여정은 지금부터 시작이야",
            "??? : 어차피 그 녀석은 우리 중 최약체.."
    };

    private static final String[] endingMonsterDialogues = {
            "인간 주제 제법이였지만 우리들 앞에선 한없이 약한 존재다",
            "이것이 마왕군의 힘이다.",
    };

    // 이름만 입력받고 나머지 값은 자동으로 랜덤 설정
    public Character(String name) {
        Random rand = new Random();
        this.name = name;
        this.health = 100;  // 고정 체력
        this.attackPower = rand.nextInt(21) + 10;  // 랜덤 기본 공격력 (10~30 사이)
        this.mana = rand.nextInt(51) + 50;  // 랜덤 마나 (50~100 사이)
        this.skillPower = rand.nextInt(31) + 20;  // 랜덤 스킬 공격력 (20~50 사이)
        this.skillManaCost = rand.nextInt(21) + 10;  // 랜덤 스킬 마나 비용 (10~30 사이)
        this.element = Element.values()[rand.nextInt(Element.values().length)];  // 랜덤 속성
    }

    // 속성에 따른 상성 계산
    public double getAdvantageMultiplier(Character opponent) {
        if (this.element == Element.WATER && opponent.element == Element.FIRE) return 2.0;
        if (this.element == Element.FIRE && opponent.element == Element.WOOD) return 2.0;
        if (this.element == Element.WOOD && opponent.element == Element.EARTH) return 2.0;
        if (this.element == Element.EARTH && opponent.element == Element.LIGHTNING) return 2.0;
        if (this.element == Element.LIGHTNING && opponent.element == Element.WATER) return 2.0;
        if (this.element == Element.FIRE && opponent.element == Element.WATER) return 0.5;
        if (this.element == Element.WOOD && opponent.element == Element.FIRE) return 0.5;
        if (this.element == Element.EARTH && opponent.element == Element.WOOD) return 0.5;
        if (this.element == Element.LIGHTNING && opponent.element == Element.EARTH) return 0.5;
        if (this.element == Element.WATER && opponent.element == Element.LIGHTNING) return 0.5;

        return 1.0;
    }

    // 영웅의 기본 공격
    public void heroBasicAttack(Character opponent) {
        System.out.println(getRandomHeroAttackDialogue());
        double multiplier = getAdvantageMultiplier(opponent);
        int damage = (int)(this.attackPower * multiplier);
        opponent.health -= damage;
        System.out.println(opponent.name + "의 남은 체력: " + opponent.health);
        System.out.println(opponent.getRandomOpponentHitDialogue());
    }

    // 영웅의 스킬 공격
    public void heroUseSkill(Character opponent) {
        if (this.mana >= this.skillManaCost) {
            System.out.println(getRandomHeroAttackDialogue());
            this.mana -= this.skillManaCost;
            double multiplier = getAdvantageMultiplier(opponent);
            int damage = (int)(this.skillPower * multiplier);
            opponent.health -= damage;
            System.out.println(opponent.name + "의 남은 체력: " + opponent.health);
            System.out.println(opponent.getRandomOpponentHitDialogue());
        } else {
            System.out.println("마나가 부족합니다. 기본 공격을 사용하세요.");
        }
    }

    // 몬스터의 기본 공격
    public void monsterBasicAttack(Character opponent) {
        System.out.println(getRandomMonsterAttackDialogue());
        double multiplier = getAdvantageMultiplier(opponent);
        int damage = (int)(this.attackPower * multiplier);
        opponent.health -= damage;
        System.out.println(opponent.name + "의 남은 체력: " + opponent.health);
        System.out.println(opponent.getRandomSelfHitDialogue());
    }

    // 몬스터의 스킬 공격
    public void monsterUseSkill(Character opponent) {
        if (this.mana >= this.skillManaCost) {
            System.out.println(getRandomMonsterAttackDialogue());
            this.mana -= this.skillManaCost;
            double multiplier = getAdvantageMultiplier(opponent);
            int damage = (int)(this.skillPower * multiplier);
            opponent.health -= damage;
            System.out.println(opponent.name + "의 남은 체력: " + opponent.health);
            System.out.println(opponent.getRandomSelfHitDialogue());
        } else {
            System.out.println("마나가 부족합니다. 기본 공격을 사용하세요.");
        }
    }

    // 공격 당할 때 대사
    public String getRandomOpponentHitDialogue() {
        Random rand = new Random();
        return opponentHitDialogues[rand.nextInt(opponentHitDialogues.length)];
    }

    // 내가 공격 당할 때 대사
    public String getRandomSelfHitDialogue() {
        Random rand = new Random();
        return selfHitDialogues[rand.nextInt(selfHitDialogues.length)];
    }

    // 영웅이 공격할 때 대사
    public String getRandomHeroAttackDialogue() {
        Random rand = new Random();
        return heroAttackDialogues[rand.nextInt(heroAttackDialogues.length)];
    }

    // 몬스터가 공격할 때 대사
    public String getRandomMonsterAttackDialogue() {
        Random rand = new Random();
        return monsterAttackDialogues[rand.nextInt(monsterAttackDialogues.length)];
    }

    // 영웅이 이겼을 때 대사
    public String getRandomEndingHeroDialogue() {
        Random rand = new Random();
        return endingHeroDialogues[rand.nextInt(endingHeroDialogues.length)];
    }

    // 몬스터가 이겼을 때 대사
    public String getRandomEndingMonsterDialogue() {
        Random rand = new Random();
        return endingMonsterDialogues[rand.nextInt(endingMonsterDialogues.length)];
    }

    // 캐릭터가 살아있는지 여부 확인
    public boolean isAlive() {
        return this.health > 0;
    }
}

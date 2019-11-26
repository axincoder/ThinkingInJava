package com.jacky.interfaces.multi;

//第一个接口
interface Monster {
	void menace();
}
//第二个接口，通过继承扩展接口，注意哦，这里用的是extends关键字
interface DangerousMonster extends Monster {
	void destory();
}
//第三个接口
interface Lethal {
	void kill();
}
//第四个接口，通过继承，继续扩展接口
interface Vampire extends DangerousMonster, Lethal {
	void drinkBlood();
}

/*
 * 定义第一个实现类(根据接口扩展，需要实现2个方法）
 */
class DragonZilla implements DangerousMonster {

	@Override
	public void menace() {}
	
	@Override
	public void destory() {}
	
}

/*
 * 定义一个实现类（根据接口扩展，需要实现4个方法）
 */
class VeryBadVampire implements Vampire {

	@Override
	public void destory() {}

	@Override
	public void menace() {}

	@Override
	public void kill() {}

	@Override
	public void drinkBlood() {}
	
}


public class HorrorShow {

}

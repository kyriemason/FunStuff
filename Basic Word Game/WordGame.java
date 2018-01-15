/** This is a basic dungeon word game 
 * 
 */
import java.util.Random;
import FormatIO.*;

public class WordGame {
	public static void main (String[] args)
	{
		//Create objects
		Console con = new Console ();
		Random rand = new Random ();
		
		// Enemy variables
		String[] enemies = {"Wizzrobe", "Lizalfo", "Bokoblin", "Octorok"};
		int maxEnemyHealth = 75;
		int enemyAttackDamage = 25;
		
		// Player variables
		int health = 100;
		int attackDamage = 50;
		int numHealthPotions = 3;
		int healthPotionHealAmmount = 30;
		int healthPotionDropChance = 50; //percentage
		
		boolean running = true;
		con.println ("Welcome to the Dungeon!"
				   + "\nPrepare for an enemy!");
		
		// start game while loop
		GAME:
		while (running) 
		{
			con.println ("-----------------------------------");
			
			int enemyHealth = rand.nextInt(maxEnemyHealth);
			String enemy = enemies[rand.nextInt(enemies.length)];
			con.println("\t> " + enemy + " appeared! <\n");
			
			// start battle while loop
			BATTLE:
			while(enemyHealth > 0)
			{
				con.println("\tYour HP: " + health);
				con.println("\t" + enemy + "'s HP: " + enemyHealth);
				con.println("\n\tHow do you want to proceed?");
				con.println("\t1 - Attack");
				con.println("\t2 - Drink health potion");
				con.println("\t3 - Run away");
				
				String input = con.readLine();
				
				// If else statement for battle, potion, or run
				if (input.equals("1")) // If chose to attack
				{
					int damageDealt = rand.nextInt(attackDamage);
					int damageTaken = rand.nextInt(enemyAttackDamage);
					
					enemyHealth -= damageDealt;
					health -= damageTaken;
					
					con.println("\n\t  >  You strike " + enemy + " for " + damageDealt + " damage.");
					con.println("\t  >  You receive " + damageTaken + " in retaliation.\n");
				
					if (health <= 0) 
					{
						con.println("You've taken too much damage and have");
						break;
					}
						
				}
				else if (input.equals("2")) //If chose potion
				{
					if (numHealthPotions > 0) 
					{
						health += healthPotionHealAmmount;
						numHealthPotions--;
						
						con.println("\t You drink a health potion, healing " + healthPotionHealAmmount + " health points."
									+ "\n\t You now have " + health + " HP."
									+ "\n\t You have " + numHealthPotions + " health potions left.\n");	
					}
					else 
					{
						con.println("\t. You have no health potions left.  Defeat enemies for a chance to get one!");
					}
				}
				else if (input.equals("3")) // If chose to run
				{
					con.println("\t You've ran away from the " + enemy + "!"
							+ "\n\t Prepare to meet a new enemy.");
					continue GAME;
				}
				else 
				{
					con.println("\t Invalid command, please select an option:");
				}
			} // closing bracket for 2nd while loop
			if (health < 1) 
			{
				con.println("died! Oopsie poopsie.");
				break;
			}
			
			// defeated enemy
			con.println("-----------------------------");
			con.println(" > " + enemy + " was defeated! <");
			con.println(" > You have " + health + " HP left. <");
			
			// health potion drop chance
			if(rand.nextInt(100) < healthPotionDropChance) 
			{
				numHealthPotions++;
				con.println (" > " + enemy + " dropped a health potion! <");
				con.println (" > You now have " + numHealthPotions + " health potions. <2");		
			}
			con.println("-----------------------------");
			con.println("What do you want to do now?");
			con.println("1 - Continue the good fight!");
			con.println("2 - Get me outa here!");
			
			String input = con.readLine();
			
			while(!input.equals("1") && !input.equals("2"))
			{
				con.println("Invalid command, try again!");
				input = con.readLine();
			}
			
			if (input.equals("1"))
			{
				con.println("You continue your journey. Prepare for a new enemy!");
			}
			else if (input.equals("2"))
			{
				con.println("You run out of the dungeon screaming! You wimp.");
				break;
			}
		
		} // closing bracket for 1st while loop
		con.println("*************************"
			   + "\n** THANKS FOR PLAYING ***"
			   + "\n*************************");
	} // static void  close brackets
} // main closing bracket

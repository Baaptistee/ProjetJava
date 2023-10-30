package Representation;
import univers.personnages.PersoGroupe;
import univers.personnages.Personnage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class ChanceNode {

    /*private int random;
    private int interrogatoire=1;
    private int portemagic=0;
    private int medievalCult=2;

    public void randomEvent(){
        

        Random random=new Random();
        int randomnum= random.nextInt(10);
        if (randomnum==portemagic){
            //Recuperer liste des competences
            ArrayList <Node> choicedoor= new ArrayList<>();
            ChooseNode portemagic= new ChooseNode("magicdoors", "Vous vous retrouvez face à 3 portes ....",choicedoor );

            ArrayList <Integer> comptences= new ArrayList<>();
            //Il faut recuperer les competence du perso et leur add ou delet les bonus malus
            //PersoGroupe peroTest= new PersoGroup
            //competences.add(perso.getStrength());

          



            List <String> name= new ArrayList<>();
            name.add("Bonus");
            name.add("Malus");
            List <String> description= new ArrayList<>();
            description.add("Quel petit chanceux...");
            description.add("Quel dommage vous n'avez pas de chance/Vous n'avez rien gagné!/Mais en plus de cela vous avez perdu....");
            
            for(int i=1;i<=3;i++){
                int randomIndex= random.nextInt(name.size());
                String nameresult=name.get(randomIndex);
                String descriptionresult=name.get(randomIndex);
                InnerNode portei= new InnerNode(nameresult,descriptionresult);
                choicedoor.add(portei);
                
            }
            int randomBonusMalus= random.nextInt(5);
            int randomIndexC= random.nextInt(comptences.size());
            int competenceresult=comptences.get(randomIndexC);
            //si le titre de notre node c'est malus alors on retirera une valeur au choisie au hasard (RansomBonusMalus)a une competence choisie au hasard (competence result) et vice versa pour le bonus

            if(randomnum==interrogatoire){
                //interrogatoire
            }
            if(randomnum==medievalCult){
                //quiz sur les cults medieval
            }
            
        }

     

    }*/






}

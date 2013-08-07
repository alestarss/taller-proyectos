package socialtoilet.android.services.factories.mocks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import android.location.Location;

import socialtoilet.android.location.GPSTracker;
import socialtoilet.android.model.Comment;
import socialtoilet.android.model.IComment;
import socialtoilet.android.model.IRating;
import socialtoilet.android.model.IToilet;
import socialtoilet.android.model.IToiletTrait;
import socialtoilet.android.model.LoginUser;
import socialtoilet.android.utils.Settings;

public class ModelMockFactory
{
	private static ModelMockFactory instance;

	private Collection<IToilet> toilets;
	private Map<String, Collection<IComment>> comments;
	private Map<String, Collection<IToiletTrait>> toiletTraits;
	private Map<String, Integer> userQualificationForToilet;
	
	
	public static ModelMockFactory getIntance()
	{
		if(null == instance)
		{
			instance = new ModelMockFactory();
		}
		return instance;
	}
	
	private ModelMockFactory()
	{
		final UUID toilet1UUID = UUID.randomUUID();
		final UUID toilet2UUID = UUID.randomUUID();
		final UUID toilet3UUID = UUID.randomUUID();
		final UUID toilet4UUID = UUID.randomUUID();
		
		toilets = new ArrayList<IToilet>();
		toilets.add(new IToilet()
			{
				private int userQualification = 0;
				private int quaCount = 2;
				private int quaTotal = 8;
				
				public String getMapTitle() { return "Eso FIUBA"; }
				public String getMapSnippet() { return "Muy limpio.";}
				public double getLongitude() { return -58.369671; }
				public double getLatitude() { return -34.617995; }
				public float getRanking() { return quaTotal / (float)quaCount; }
				public UUID getID() { return toilet1UUID; }
				public String getDescription() { return "Eso Fiuba"; }
				public String getAddress() { return "Av. Paseo Col�n 834"; }
				public int getUserCalification() { return userQualification; }
				public int getUserCalificationsCount() { return quaCount; }
				public void setUserCalification(int calification) { 
					if(0 == userQualification)
					{
						userQualification = calification; quaCount++; quaTotal+= calification;
					}
					else
					{
						quaTotal += calification - userQualification;
						userQualification = calification;
					}
				}
				public void revertUserCalification() { 
					if(0 != userQualification) {
						quaTotal -= userQualification;
						quaCount--; } }
				public void setRating(IRating rating) { quaCount = rating.getCalificationCount();
					quaTotal = (int) (quaCount * rating.getRating()); }
				public void userCalificationRetrieved( int calification) { userQualification = calification;}
			});
		toilets.add(new IToilet()
			{
				private int userQualification = 0;
				private int quaCount = 5;
				private int quaTotal = 4;
			
				public String getMapTitle() { return "Pje. M. Giuffa 242 (y Paseo Col�n)"; }
				public String getMapSnippet() { return "Muchas veces cerrado.";}
				public double getLongitude() { return -58.369864; }
				public double getLatitude() { return -34.617642; }
				public float getRanking() { return quaTotal / (float)quaCount; }
				public UUID getID() { return toilet2UUID; }
				public String getDescription() { return "Mc Fiuba"; }
				public String getAddress() { return "Pje. M. Giuffa 242 (y Paseo Col�n)"; }
				public int getUserCalification() { return userQualification; }
				public int getUserCalificationsCount() { return quaCount; }
				public void setUserCalification(int calification) { 
					if(0 == userQualification)
					{
						userQualification = calification; quaCount++; quaTotal+= calification;
					}
					else
					{
						quaTotal += calification - userQualification;
						userQualification = calification;
					}
				}
				public void revertUserCalification() { 
					if(0 != userQualification) {
						quaTotal -= userQualification;
						quaCount--; } }
				public void setRating(IRating rating) { quaCount = rating.getCalificationCount();
					quaTotal = (int) (quaCount * rating.getRating()); }
				public void userCalificationRetrieved( int calification) { userQualification = calification;}
			});
		toilets.add(new IToilet()
		{
			private int userQualification = 0;
			private int quaCount = 10;
			private int quaTotal = 35;
		
			public String getMapTitle() { return "Tio Mario"; }
			public String getMapSnippet() { return "Pizzeria.";}
			public double getLongitude() { return -58.37143; }
			public double getLatitude() { return -34.618348; }
			public float getRanking() { return quaTotal / (float)quaCount; }
			public UUID getID() { return toilet3UUID; }
			public String getDescription() { return "Tio Mario - Bar"; }
			public String getAddress() { return "Defensa y EE.UU. - CABA"; }
			public int getUserCalification() { return userQualification; }
			public int getUserCalificationsCount() { return quaCount; }
			public void setUserCalification(int calification) { 
				if(0 == userQualification)
				{
					userQualification = calification; quaCount++; quaTotal+= calification;
				}
				else
				{
					quaTotal += calification - userQualification;
					userQualification = calification;
				}
			}
			public void revertUserCalification() { 
				if(0 != userQualification) {
					quaTotal -= userQualification;
					quaCount--; } }
			public void setRating(IRating rating) { quaCount = rating.getCalificationCount();
				quaTotal = (int) (quaCount * rating.getRating()); }
			public void userCalificationRetrieved( int calification) { userQualification = calification;}
		});
		toilets.add(new IToilet()
		{
			private int userQualification = 0;
			private int quaCount = 5;
			private int quaTotal = 25;
		
			public String getMapTitle() { return "Lima 662"; }
			public String getMapSnippet() { return "Ba�o de McDonalds.";}
			public double getLongitude() { return -58.381794; }
			public double getLatitude() { return -34.615947; }
			public float getRanking() { return quaTotal / (float)quaCount; }
			public UUID getID() { return toilet4UUID; }
			public String getDescription() { return "McDonalds"; }
			public String getAddress() { return "Lima 662 - CABA"; }
			public int getUserCalification() { return userQualification; }
			public int getUserCalificationsCount() { return quaCount; }
			public void setUserCalification(int calification) { 
				if(0 == userQualification)
				{
					userQualification = calification; quaCount++; quaTotal+= calification;
				}
				else
				{
					quaTotal += calification - userQualification;
					userQualification = calification;
				}
			}
			public void revertUserCalification() { 
				if(0 != userQualification) {
					quaTotal -= userQualification;
					quaCount--; } }
			public void setRating(IRating rating) { quaCount = rating.getCalificationCount();
				quaTotal = (int) (quaCount * rating.getRating()); }
			public void userCalificationRetrieved( int calification) { userQualification = calification;}
		});
		
		comments = new HashMap<String, Collection<IComment>>();
		Collection<IComment> aToiletComments = new ArrayList<IComment>();
		aToiletComments.add(new IComment()
		{
			@Override
			public UUID getUserId() { return UUID.randomUUID(); }
			@Override
			public String getUser() { return "damian"; }
			@Override
			public String getContent() { 
				return "Totalmente recomendado."; }
			@Override
			public Collection<String> getLikeUsers() { return new ArrayList<String>(); }
			@Override
			public String getDate() { return "15:56hs 2013/07/13"; }
		});
		aToiletComments.add(new IComment()
		{
			@Override
			public UUID getUserId() { return UUID.randomUUID(); }
			@Override
			public String getUser() { return "sebas"; }
			@Override
			public String getContent() { 
				return "Cuando llegu�, estaba cerrado. Pero me lo abrieron y despu�s me tome un caf� muy bueno."; }
			@Override
			public Collection<String> getLikeUsers() { return new ArrayList<String>(
				    Arrays.asList("damian", "gus", "matias")); }
			@Override
			public String getDate() { return "11:11hs 2013/07/18"; }
		});
		aToiletComments.add(new IComment()
		{
			@Override
			public UUID getUserId() { return UUID.randomUUID(); }
			@Override
			public String getUser() { return "mservetto"; }
			@Override
			public String getContent() { 
				return "Ya no est�n limpiando este ba�o. Est�n las tablas sucias"; }
			@Override
			public Collection<String> getLikeUsers() { return new ArrayList<String>(); }
			@Override
			public String getDate() { return "25:25hs 2013/07/22"; }
		});
		aToiletComments.add(new IComment()
		{
			@Override
			public UUID getUserId() { return UUID.randomUUID(); }
			@Override
			public String getUser() { return "damian"; }
			@Override
			public String getContent() { 
				return "Que raro, cuando fui yo estaba 10 puntos."; }
			@Override
			public Collection<String> getLikeUsers() { return new ArrayList<String>(); }
			@Override
			public String getDate() { return "15:25hs 2013/07/22"; }
		});
		aToiletComments.add(new IComment()
		{
			@Override
			public UUID getUserId() { return UUID.randomUUID(); }
			@Override
			public String getUser() { return "gus"; }
			@Override
			public String getContent() { 
				return "Lo confirmo."; }
			@Override
			public Collection<String> getLikeUsers() { return new ArrayList<String>(); }
			@Override
			public String getDate() { return "5:05hs 2013/07/24"; }
		});
		aToiletComments.add(new IComment()
		{
			@Override
			public UUID getUserId() { return UUID.randomUUID(); }
			@Override
			public String getUser() { return "ricardo"; }
			@Override
			public String getContent() { 
				return "Disculpen por las molestias. ya lo limpiamos y lo pusimos  punto. Vengan y de paso coman nuestras tortas, las m�s ricas de Buenos Aires!"; }
			@Override
			public Collection<String> getLikeUsers() { return new ArrayList<String>(); }
			@Override
			public String getDate() { return "88:99hs 2013/07/25"; }
		});
		aToiletComments.add(new IComment()
		{
			@Override
			public UUID getUserId() { return UUID.randomUUID(); }
			@Override
			public String getUser() { return "mservetto"; }
			@Override
			public String getContent() { 
				return "Las mejores!!"; }
			@Override
			public Collection<String> getLikeUsers() { return new ArrayList<String>(); }
			@Override
			public String getDate() { return "24:00hs 2013/07/25"; }
		});
		aToiletComments.add(new IComment()
		{
			@Override
			public UUID getUserId() { return UUID.randomUUID(); }
			@Override
			public String getUser() { return "sebas"; }
			@Override
			public String getContent() { 
				return "Genio. Amo esta aplicaci�n"; }
			@Override
			public Collection<String> getLikeUsers() { return new ArrayList<String>(); }
			@Override
			public String getDate() { return "15:99hs 2013/07/26"; }
		});
		comments.put(toilet1UUID.toString(), aToiletComments);
		
		aToiletComments = new ArrayList<IComment>();
		aToiletComments.add(new IComment()
		{
			@Override
			public UUID getUserId() { return UUID.randomUUID(); }
			@Override
			public String getUser() { return "mservetto"; }
			@Override
			public String getContent() { 
				return "Muy cuidado y prolijo."; }
			@Override
			public Collection<String> getLikeUsers() { return new ArrayList<String>(); }
			@Override
			public String getDate() { return "15:56hs 2013/07/13"; }
		});
		comments.put(toilet2UUID.toString(), aToiletComments);

		aToiletComments = new ArrayList<IComment>();
		aToiletComments.add(new IComment()
		{
			@Override
			public UUID getUserId() { return UUID.randomUUID(); }
			@Override
			public String getUser() { return "mservetto"; }
			@Override
			public String getContent() { 
				return "Muy cuidado y prolijo."; }
			@Override
			public Collection<String> getLikeUsers() { return new ArrayList<String>(); }
			@Override
			public String getDate() { return "15:56hs 2013/07/13"; }
		});
		comments.put(toilet3UUID.toString(), aToiletComments);
		
		aToiletComments = new ArrayList<IComment>();
		comments.put(toilet4UUID.toString(), aToiletComments);
		
		toiletTraits = new HashMap<String, Collection<IToiletTrait>>();
		Collection<IToiletTrait> traits = new ArrayList<IToiletTrait>();
		traits.add(new IToiletTrait()
		{
			private boolean value = false;
			@Override
			public boolean hasDescription() { return value; }
			@Override
			public void setHasDescription(boolean has) { value = has; }
			@Override
			public int getId() { return 0; }
			@Override
			public String getDescription() { return "Dejan pasar sin consumir"; }
		});
		traits.add(new IToiletTrait()
		{
			private boolean value = false;
			@Override
			public boolean hasDescription() { return value; }
			@Override
			public void setHasDescription(boolean has) { value = has; }
			@Override
			public int getId() { return 1; }
			@Override
			public String getDescription() { return "Tiene agua"; }
		});
		traits.add(new IToiletTrait()
		{
			private boolean value = true;
			@Override
			public boolean hasDescription() { return value; }
			@Override
			public void setHasDescription(boolean has) { value = has; }
			@Override
			public int getId() { return 2; }
			@Override
			public String getDescription() { return "Tiene papel"; }
		});
		traits.add(new IToiletTrait()
		{
			private boolean value = false;
			@Override
			public boolean hasDescription() { return value; }
			@Override
			public void setHasDescription(boolean has) { value = has; }
			@Override
			public int getId() { return 3; }
			@Override
			public String getDescription() { return "Tiene jabon"; }
		});
		traits.add(new IToiletTrait()
		{
			private boolean value = true;
			@Override
			public boolean hasDescription() { return value; }
			@Override
			public void setHasDescription(boolean has) { value = has; }
			@Override
			public int getId() { return 4; }
			@Override
			public String getDescription() { return "Tiene espejo"; }
		});
		traits.add(new IToiletTrait()
		{
			private boolean value = false;
			@Override
			public boolean hasDescription() { return value; }
			@Override
			public void setHasDescription(boolean has) { value = has; }
			@Override
			public int getId() { return 5; }
			@Override
			public String getDescription() { return "Las puertas de las cabinas cierran"; }
		});
		traits.add(new IToiletTrait()
		{
			private boolean value = true;
			@Override
			public boolean hasDescription() { return value; }
			@Override
			public void setHasDescription(boolean has) { value = has; }
			@Override
			public int getId() { return 6; }
			@Override
			public String getDescription() { return "Tiene insumos femeninos a la venta"; }
		});
		traits.add(new IToiletTrait()
		{
			private boolean value = true;
			@Override
			public boolean hasDescription() { return value; }
			@Override
			public void setHasDescription(boolean has) { value = has; }
			@Override
			public int getId() { return 7; }
			@Override
			public String getDescription() { return "Tiene preservativos a la venta"; }
		});
		traits.add(new IToiletTrait()
		{
			private boolean value = false;
			@Override
			public boolean hasDescription() { return value; }
			@Override
			public void setHasDescription(boolean has) { value = has; }
			@Override
			public int getId() { return 8; }
			@Override
			public String getDescription() { return "Apto para discapacitados"; }
		});
		traits.add(new IToiletTrait()
		{
			private boolean value = true;
			@Override
			public boolean hasDescription() { return value; }
			@Override
			public void setHasDescription(boolean has) { value = has; }
			@Override
			public int getId() { return 9; }
			@Override
			public String getDescription() { return "Tiene cambiador de bebes"; }
		});
		toiletTraits.put(toilet1UUID.toString(), traits);
		traits = new ArrayList<IToiletTrait>();
		traits.add(new IToiletTrait()
		{
			private boolean value = false;
			@Override
			public boolean hasDescription() { return value; }
			@Override
			public void setHasDescription(boolean has) { value = has; }
			@Override
			public int getId() { return 0; }
			@Override
			public String getDescription() { return "Dejan pasar sin consumir"; }
		});
		traits.add(new IToiletTrait()
		{
			private boolean value = true;
			@Override
			public boolean hasDescription() { return value; }
			@Override
			public void setHasDescription(boolean has) { value = has; }
			@Override
			public int getId() { return 1; }
			@Override
			public String getDescription() { return "Tiene agua"; }
		});
		traits.add(new IToiletTrait()
		{
			private boolean value = true;
			@Override
			public boolean hasDescription() { return value; }
			@Override
			public void setHasDescription(boolean has) { value = has; }
			@Override
			public int getId() { return 2; }
			@Override
			public String getDescription() { return "Tiene papel"; }
		});
		traits.add(new IToiletTrait()
		{
			private boolean value = true;
			@Override
			public boolean hasDescription() { return value; }
			@Override
			public void setHasDescription(boolean has) { value = has; }
			@Override
			public int getId() { return 3; }
			@Override
			public String getDescription() { return "Tiene jabon"; }
		});
		traits.add(new IToiletTrait()
		{
			private boolean value = true;
			@Override
			public boolean hasDescription() { return value; }
			@Override
			public void setHasDescription(boolean has) { value = has; }
			@Override
			public int getId() { return 4; }
			@Override
			public String getDescription() { return "Tiene espejo"; }
		});
		traits.add(new IToiletTrait()
		{
			private boolean value = true;
			@Override
			public boolean hasDescription() { return value; }
			@Override
			public void setHasDescription(boolean has) { value = has; }
			@Override
			public int getId() { return 5; }
			@Override
			public String getDescription() { return "Las puertas de las cabinas cierran"; }
		});
		traits.add(new IToiletTrait()
		{
			private boolean value = false;
			@Override
			public boolean hasDescription() { return value; }
			@Override
			public void setHasDescription(boolean has) { value = has; }
			@Override
			public int getId() { return 6; }
			@Override
			public String getDescription() { return "Tiene insumos femeninos a la venta"; }
		});
		traits.add(new IToiletTrait()
		{
			private boolean value = false;
			@Override
			public boolean hasDescription() { return value; }
			@Override
			public void setHasDescription(boolean has) { value = has; }
			@Override
			public int getId() { return 7; }
			@Override
			public String getDescription() { return "Tiene preservativos a la venta"; }
		});
		traits.add(new IToiletTrait()
		{
			private boolean value = false;
			@Override
			public boolean hasDescription() { return value; }
			@Override
			public void setHasDescription(boolean has) { value = has; }
			@Override
			public int getId() { return 8; }
			@Override
			public String getDescription() { return "Apto para discapacitados"; }
		});
		traits.add(new IToiletTrait()
		{
			private boolean value = false;
			@Override
			public boolean hasDescription() { return value; }
			@Override
			public void setHasDescription(boolean has) { value = has; }
			@Override
			public int getId() { return 9; }
			@Override
			public String getDescription() { return "Tiene cambiador de bebes"; }
		});
		toiletTraits.put(toilet2UUID.toString(), traits);
		traits = new ArrayList<IToiletTrait>();
		traits.add(new IToiletTrait()
		{
			private boolean value = false;
			@Override
			public boolean hasDescription() { return value; }
			@Override
			public void setHasDescription(boolean has) { value = has; }
			@Override
			public int getId() { return 0; }
			@Override
			public String getDescription() { return "Dejan pasar sin consumir"; }
		});
		traits.add(new IToiletTrait()
		{
			private boolean value = true;
			@Override
			public boolean hasDescription() { return value; }
			@Override
			public void setHasDescription(boolean has) { value = has; }
			@Override
			public int getId() { return 1; }
			@Override
			public String getDescription() { return "Tiene agua"; }
		});
		traits.add(new IToiletTrait()
		{
			private boolean value = true;
			@Override
			public boolean hasDescription() { return value; }
			@Override
			public void setHasDescription(boolean has) { value = has; }
			@Override
			public int getId() { return 2; }
			@Override
			public String getDescription() { return "Tiene papel"; }
		});
		traits.add(new IToiletTrait()
		{
			private boolean value = true;
			@Override
			public boolean hasDescription() { return value; }
			@Override
			public void setHasDescription(boolean has) { value = has; }
			@Override
			public int getId() { return 3; }
			@Override
			public String getDescription() { return "Tiene jabon"; }
		});
		traits.add(new IToiletTrait()
		{
			private boolean value = true;
			@Override
			public boolean hasDescription() { return value; }
			@Override
			public void setHasDescription(boolean has) { value = has; }
			@Override
			public int getId() { return 4; }
			@Override
			public String getDescription() { return "Tiene espejo"; }
		});
		traits.add(new IToiletTrait()
		{
			private boolean value = true;
			@Override
			public boolean hasDescription() { return value; }
			@Override
			public void setHasDescription(boolean has) { value = has; }
			@Override
			public int getId() { return 5; }
			@Override
			public String getDescription() { return "Las puertas de las cabinas cierran"; }
		});
		traits.add(new IToiletTrait()
		{
			private boolean value = false;
			@Override
			public boolean hasDescription() { return value; }
			@Override
			public void setHasDescription(boolean has) { value = has; }
			@Override
			public int getId() { return 6; }
			@Override
			public String getDescription() { return "Tiene insumos femeninos a la venta"; }
		});
		traits.add(new IToiletTrait()
		{
			private boolean value = false;
			@Override
			public boolean hasDescription() { return value; }
			@Override
			public void setHasDescription(boolean has) { value = has; }
			@Override
			public int getId() { return 7; }
			@Override
			public String getDescription() { return "Tiene preservativos a la venta"; }
		});
		traits.add(new IToiletTrait()
		{
			private boolean value = false;
			@Override
			public boolean hasDescription() { return value; }
			@Override
			public void setHasDescription(boolean has) { value = has; }
			@Override
			public int getId() { return 8; }
			@Override
			public String getDescription() { return "Apto para discapacitados"; }
		});
		traits.add(new IToiletTrait()
		{
			private boolean value = false;
			@Override
			public boolean hasDescription() { return value; }
			@Override
			public void setHasDescription(boolean has) { value = has; }
			@Override
			public int getId() { return 9; }
			@Override
			public String getDescription() { return "Tiene cambiador de bebes"; }
		});
		toiletTraits.put(toilet3UUID.toString(), traits);
		traits = new ArrayList<IToiletTrait>();
		traits.add(new IToiletTrait()
		{
			private boolean value = false;
			@Override
			public boolean hasDescription() { return value; }
			@Override
			public void setHasDescription(boolean has) { value = has; }
			@Override
			public int getId() { return 0; }
			@Override
			public String getDescription() { return "Dejan pasar sin consumir"; }
		});
		traits.add(new IToiletTrait()
		{
			private boolean value = true;
			@Override
			public boolean hasDescription() { return value; }
			@Override
			public void setHasDescription(boolean has) { value = has; }
			@Override
			public int getId() { return 1; }
			@Override
			public String getDescription() { return "Tiene agua"; }
		});
		traits.add(new IToiletTrait()
		{
			private boolean value = true;
			@Override
			public boolean hasDescription() { return value; }
			@Override
			public void setHasDescription(boolean has) { value = has; }
			@Override
			public int getId() { return 2; }
			@Override
			public String getDescription() { return "Tiene papel"; }
		});
		traits.add(new IToiletTrait()
		{
			private boolean value = true;
			@Override
			public boolean hasDescription() { return value; }
			@Override
			public void setHasDescription(boolean has) { value = has; }
			@Override
			public int getId() { return 3; }
			@Override
			public String getDescription() { return "Tiene jabon"; }
		});
		traits.add(new IToiletTrait()
		{
			private boolean value = true;
			@Override
			public boolean hasDescription() { return value; }
			@Override
			public void setHasDescription(boolean has) { value = has; }
			@Override
			public int getId() { return 4; }
			@Override
			public String getDescription() { return "Tiene espejo"; }
		});
		traits.add(new IToiletTrait()
		{
			private boolean value = true;
			@Override
			public boolean hasDescription() { return value; }
			@Override
			public void setHasDescription(boolean has) { value = has; }
			@Override
			public int getId() { return 5; }
			@Override
			public String getDescription() { return "Las puertas de las cabinas cierran"; }
		});
		traits.add(new IToiletTrait()
		{
			private boolean value = false;
			@Override
			public boolean hasDescription() { return value; }
			@Override
			public void setHasDescription(boolean has) { value = has; }
			@Override
			public int getId() { return 6; }
			@Override
			public String getDescription() { return "Tiene insumos femeninos a la venta"; }
		});
		traits.add(new IToiletTrait()
		{
			private boolean value = false;
			@Override
			public boolean hasDescription() { return value; }
			@Override
			public void setHasDescription(boolean has) { value = has; }
			@Override
			public int getId() { return 7; }
			@Override
			public String getDescription() { return "Tiene preservativos a la venta"; }
		});
		traits.add(new IToiletTrait()
		{
			private boolean value = false;
			@Override
			public boolean hasDescription() { return value; }
			@Override
			public void setHasDescription(boolean has) { value = has; }
			@Override
			public int getId() { return 8; }
			@Override
			public String getDescription() { return "Apto para discapacitados"; }
		});
		traits.add(new IToiletTrait()
		{
			private boolean value = false;
			@Override
			public boolean hasDescription() { return value; }
			@Override
			public void setHasDescription(boolean has) { value = has; }
			@Override
			public int getId() { return 9; }
			@Override
			public String getDescription() { return "Tiene cambiador de bebes"; }
		});
		toiletTraits.put(toilet4UUID.toString(), traits);
		
		userQualificationForToilet = new HashMap<String, Integer>();
	}

	public Collection<IToilet> getNearToilets()
	{
		GPSTracker gps = GPSTracker.getInstance();
		Settings set= Settings.getInstance();
		double actualLat = gps.getLatitude();
		double actualLong = gps.getLongitude();
		float distance = (float) set.getInitialRadiusInMeters();
		Collection<IToilet> nearToilets = new ArrayList<IToilet>();;
		
		float[] results = new float[5];
		for(IToilet toilet : toilets) {
			Location.distanceBetween(actualLat, actualLong,
	                toilet.getLatitude(), toilet.getLongitude(), results);
			if ( results[0] <= distance) {
				nearToilets.add(toilet);
			}
		}
		

		return nearToilets;
	}

	public void addToilet(IToilet toilet)
	{
		toilets.add(toilet);
		comments.put(toilet.getID().toString(), new ArrayList<IComment>());
	}

	public IToilet getToilet(UUID toiletId)
	{
		for(IToilet toilet : toilets)
		{
			if(toilet.getID().toString().equalsIgnoreCase(toiletId.toString()))
			{
				return toilet;
			}
		}
		return null;
	}

	public Collection<IComment> getToiletComments(UUID toiletId)
	{
		return comments.get(toiletId.toString());
	}

	public void addToiletComment(String toiletId, Comment comment)
	{
		comments.get(toiletId).add(comment);
	}

	public boolean authUser(LoginUser user)
	{
		if(user.getUser().equalsIgnoreCase("mservetto") && user.getPassword().equalsIgnoreCase("password"))
		{
			user.setUserId(UUID.fromString("123-123-123-123-123"));
			return true;
		}
		if(user.getUser().equalsIgnoreCase("srodriguez") && user.getPassword().equalsIgnoreCase("password"))
		{
			user.setUserId(UUID.fromString("456-456-456-456-546"));
			return true;
		}
		if(user.getUser().equalsIgnoreCase("dschenkelman") && user.getPassword().equalsIgnoreCase("password"))
		{
			user.setUserId(UUID.fromString("789-789-789-789-789"));
			return true;
		}
		return false;
	}

	public boolean hasUserQualificatedToilet(String toiletId)
	{
		Integer qua = userQualificationForToilet.get(toiletId+Settings.getInstance().getUserId().toString());
		return null != qua;
	}

	public double getUserQualification(String toiletId)
	{
		Integer qua = userQualificationForToilet.get(toiletId+Settings.getInstance().getUserId().toString());
		return ((null == qua) ? 0 : qua);
	}

	public void setUserQualification(String toiletId, int userQualification)
	{
		userQualificationForToilet.put(toiletId+Settings.getInstance().getUserId().toString(), userQualification);
	}
	
	public void editTraits(String toiletId, Collection<IToiletTrait> traits)
	{
		toiletTraits.put(toiletId, traits);
	}

	public Collection<IToiletTrait> getTraits(UUID id)
	{
		return toiletTraits.get(id.toString());
	}

	public void clearToiletUserData()
	{
		for(IToilet toilet : toilets)
		{
			toilet.userCalificationRetrieved(0);
		}
	}

}

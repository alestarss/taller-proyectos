package socialtoilet.android.services.factories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import android.util.Log;

import socialtoilet.android.location.GPSTracker;
import socialtoilet.android.model.IComment;
import socialtoilet.android.model.IToilet;
import socialtoilet.android.model.Toilet;
import socialtoilet.android.services.AddToiletService;
import socialtoilet.android.services.CalificateToiletService;
import socialtoilet.android.services.IAddToiletService;
import socialtoilet.android.services.IAddToiletServiceDelegate;
import socialtoilet.android.services.ICalificateToiletService;
import socialtoilet.android.services.ICalificateToiletServiceDelegate;
import socialtoilet.android.services.IRetrieveNearToiletsService;
import socialtoilet.android.services.IRetrieveNearToiletsServiceDelegate;
import socialtoilet.android.services.IRetrieveToiletCommentsService;
import socialtoilet.android.services.IRetrieveToiletCommentsServiceDelegate;
import socialtoilet.android.services.IRetrieveToiletService;
import socialtoilet.android.services.IRetrieveToiletServiceDelegate;
import socialtoilet.android.services.RetrieveNearToiletsService;
import socialtoilet.android.services.RetrieveToiletCommentsService;
import socialtoilet.android.services.RetrieveToiletService;
import socialtoilet.android.utils.Settings;

public class ServicesFactory
{

	private ServicesFactory() {}
	
	public static IAddToiletService createAddToiletService()
	{
		if(Settings.getInstance().isServicesDebugMode())
		{
			return new IAddToiletService()
			{
				@Override
				public void addToilet(Toilet toilet, IAddToiletServiceDelegate delegate)
				{
					delegate.addToiletFinish(this);
				}
			};
		}
		return new AddToiletService();
	}
	
	public static IRetrieveNearToiletsService createRetrieveNearToiletsService()
	{
		if(Settings.getInstance().isServicesDebugMode())
		{
			return new IRetrieveNearToiletsService()
			{
				@Override
				public void retrieveNearToilets(double latitude, double longitude,
						int distanceInMeters, IRetrieveNearToiletsServiceDelegate delegate)
				{
					Collection<IToilet> toilets = new ArrayList<IToilet>();
					toilets.add(new IToilet()
						{
							@Override
							public String getMapTitle() { return "La Roma"; }
							@Override
							public String getMapSnippet() { return "Tambi�n venden pizza.";}
							@Override
							public double getLongitude() { return GPSTracker.getInstance().getLongitude() + 0.001; }
							@Override
							public double getLatitude() { return GPSTracker.getInstance().getLatitude() - 0.002; }
							@Override
							public float getRanking() { return 2.5f; }
							@Override
							public UUID getID() { return UUID.randomUUID(); }
							@Override
							public String getDescription() { return "Es un buen ba�o"; }
							@Override
							public String getAddress() { return "Av. Yrigoyen 1565, El Talar"; }
							@Override
							public int getUserCalification() { return 0; }
							@Override
							public int getUserCalificationsCount() { return 25; }
							@Override
							public void setUserCalification(int calification) { }
							@Override
							public void revertUserCalification() { }
						});
					toilets.add(new IToilet()
						{
							@Override
							public String getMapTitle() { return "Eso"; }
							@Override
							public String getMapSnippet() { return "Siempre cerrado.";}
							@Override
							public double getLongitude() { return GPSTracker.getInstance().getLongitude() + 0.003; }
							@Override
							public double getLatitude() { return GPSTracker.getInstance().getLatitude() - 0.005; }
							@Override
							public float getRanking() { return 2.5f; }
							@Override
							public UUID getID() { return UUID.randomUUID(); }
							@Override
							public String getDescription() { return "Esta re cuidado"; }
							@Override
							public String getAddress() { return "Av. Yrigoyen 1355, El Talar"; }
							@Override
							public int getUserCalification() { return 2; }
							@Override
							public int getUserCalificationsCount() { return 31; }
							@Override
							public void setUserCalification(int calification) { }
							@Override
							public void revertUserCalification() { }
						});
					
					delegate.retrieveNearToiletsFinish(this, toilets);
				}
			};
		}
		return new RetrieveNearToiletsService();
	}
	
	public static IRetrieveToiletService createRetrieveToiletService()
	{
		if(Settings.getInstance().isServicesDebugMode())
		{
			return new IRetrieveToiletService()
			{
				@Override
				public void retrieveToilet(UUID toiletId,
						IRetrieveToiletServiceDelegate detailToiletActivity)
				{
					final UUID id = toiletId;
					detailToiletActivity.retrieveToiletFinish(this, new IToilet()
					{
						private int userCalification = 0;
						private float ranking = 1.5f;
						private int userCalificationsCount = 2;
						
						@Override
						public String getMapTitle() { return "La Roma"; }
						@Override
						public String getMapSnippet() { return "Tambi�n venden pizza.";}
						@Override
						public double getLongitude() { return -34.465849; }
						@Override
						public double getLatitude() { return -58.645337; }
						@Override
						public float getRanking() { return ranking; }
						@Override
						public UUID getID() { return id; }
						@Override
						public String getDescription() { return "Es un buen ba�o"; }
						@Override
						public String getAddress() { return "Av. Yrigoyen 1565, El Talar"; }
						@Override
						public int getUserCalification() { return userCalification; }
						@Override
						public int getUserCalificationsCount() { return userCalificationsCount; }
						@Override
						public void setUserCalification(int calification)
						{
							Log.d("Social Toilet", "Ranking viejo: " + ranking);
							if(0 == userCalification)
							{
								ranking = (ranking * userCalificationsCount + calification) / (userCalificationsCount + 1);
								userCalificationsCount++;
							}
							else
							{
								ranking = (ranking * userCalificationsCount - userCalification) / (float)(userCalificationsCount - 1);
								ranking = (ranking * (userCalificationsCount - 1) + calification) / (float)userCalificationsCount;
							}
							userCalification = calification;
							Log.d("Social Toilet", "Ranking Nuevo: " + ranking);
						}
						@Override
						public void revertUserCalification()
						{
							if(0 != userCalification)
							{
								ranking = (ranking * userCalificationsCount - userCalification) / (float)(userCalificationsCount - 1);
								userCalification = 0;
								userCalificationsCount--;
							}
						}
					});
				}
			};
		}
		return new RetrieveToiletService();
	}
	
	public static ICalificateToiletService createCalificateToiletService()
	{
		if(Settings.getInstance().isServicesDebugMode())
		{
			return new ICalificateToiletService()
			{
				@Override
				public void calificateToiletService(IToilet toilet, int userCalification,
						ICalificateToiletServiceDelegate delegate)
				{
					delegate.calificateToiletFinish(this);
				}
			};
		}
		return new CalificateToiletService();
	}

	public static IRetrieveToiletCommentsService createRetrieveToiletCommentsService()
	{
		if(Settings.getInstance().isServicesDebugMode())
		{
			return new IRetrieveToiletCommentsService()
			{

				@Override
				public void retrieveToiletComments(UUID toiletId,
						IRetrieveToiletCommentsServiceDelegate delegate)
				{
					Collection<IComment> comments = new ArrayList<IComment>();
					// TODO hardcode some IComments
					delegate.retrieveToiletCommentsFinish(this, comments);
				}
			};
		}
		return new RetrieveToiletCommentsService();
	}
}

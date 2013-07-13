﻿namespace SocialToilet.Api
{
    using System.Web.Http;
    using System.Web.Mvc;

    using SocialToilet.Api.Database;
    using SocialToilet.Api.Filters;

    public class WebApiApplication : System.Web.HttpApplication
    {
        protected void Application_Start()
        {
            System.Data.Entity.Database.SetInitializer(new SocialToiletInitializer());

            AreaRegistration.RegisterAllAreas();

            WebApiConfig.Register(GlobalConfiguration.Configuration);
            FilterConfig.RegisterGlobalFilters(GlobalFilters.Filters);

            GlobalConfiguration.Configuration.MessageHandlers.Add(new RequireHttpsMessageHandler());
        }
    }
}
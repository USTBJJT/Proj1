Imports Microsoft.VisualBasic
Imports cn.com.webxml


Public Class WeatherClass


    Public Shared Function getDataSet() As DataSet
        Dim ds As DataSet = CType(HttpContext.Current.Cache("dataSetCache"), DataSet)
        If ds Is Nothing Then '判断缓存
            Dim weather As WeatherWebService = New WeatherWebService()
            ds = weather.getSupportDataSet()
            HttpContext.Current.Cache.Insert("dataSetCache", ds, Nothing, DateTime.Now.AddHours(12), _
            TimeSpan.Zero, CacheItemPriority.High, Nothing) '添加Cache缓存数据提高速度
        End If
        Return ds
    End Function

    Public Shared Function getCityWeather(ByVal cityCode As String) As String()
        Dim cacheName As String = "weather" & cityCode.Trim()
        Dim weatherArray() As String = CType(HttpContext.Current.Cache(cacheName), String())
        If weatherArray Is Nothing Then
            Dim weather As WeatherWebService = New WeatherWebService()
            weatherArray = weather.getWeatherbyCityName(cityCode)
            HttpContext.Current.Cache.Insert(cacheName, weatherArray, Nothing, DateTime.Now.AddMinutes(90), _
            TimeSpan.Zero, CacheItemPriority.High, Nothing) '添加Cache缓存数据提高速度
        End If
        Return weatherArray
    End Function


End Class

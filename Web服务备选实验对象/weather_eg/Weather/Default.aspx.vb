Imports cn.com.webxml
Imports System.Threading


Partial Class _Default
    Inherits System.Web.UI.Page

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load
        Try
            Dim ds As DataSet = WeatherClass.getDataSet()
            If Not Page.IsPostBack Then
                Dim provinceTable As DataTable = ds.Tables(0)
                Dim provinceView As DataView = New DataView(ds.Tables(0))
                'provinceView.RowFilter = "[ID] <= 30 " '只选择中国城市
                Province.DataSource = provinceView
                Province.DataTextField = "Zone"
                Province.DataValueField = "ID"
                Province.DataBind()
                Province.SelectedIndex = 0
                City.SelectedIndex = 1
                CityDataBind("1") '默认直辖市
                Weather("58367") '默认上海
            End If
        Catch ex As Exception
            'Title.Text = ex.Message
            Title.Text = "发现一个错误"
        End Try
    End Sub

    Protected Sub City_SelectedIndexChanged(ByVal sender As Object, ByVal e As System.EventArgs) Handles City.SelectedIndexChanged
        If City.Items(0).Value = "0" Then
            City.Items.RemoveAt(0)
        End If
        Weather(City.SelectedItem.Value.Trim())
    End Sub

    Protected Sub Province_SelectedIndexChanged(ByVal sender As Object, ByVal e As System.EventArgs) Handles Province.SelectedIndexChanged
        
        CityDataBind(Province.SelectedItem.Value.Trim())

    End Sub

    Protected Sub CityDataBind(ByVal zoneID As String)
        Dim ds As DataSet = WeatherClass.getDataSet()
        Dim cityView As DataView = New DataView(ds.Tables(1))
        cityView.RowFilter = "[ZoneID] = " & zoneID
        City.DataSource = cityView
        City.DataTextField = "Area"
        City.DataValueField = "AreaCode"
        City.DataBind()
        City.Items.Insert(0, New ListItem("选择城市", "0"))
        City.SelectedIndex = 0
    End Sub

    Protected Sub Weather(ByVal cityCode As String)
        Dim wa() As String = WeatherClass.getCityWeather(cityCode.Trim())
        Label1.Text = wa(10)
        Label2.Text = wa(6) & "&nbsp;&nbsp;&nbsp;" & wa(5) & "&nbsp;&nbsp;&nbsp;" & wa(7)
        Label3.Text = wa(13) & "&nbsp;&nbsp;&nbsp;" & wa(12) & "&nbsp;&nbsp;&nbsp;" & wa(14)
        Label4.Text = wa(18) & "&nbsp;&nbsp;&nbsp;" & wa(17) & "&nbsp;&nbsp;&nbsp;" & wa(19)
        Label5.Text = wa(11).Replace(Chr(10), "<br />")
        Label6.Text = wa(22).Replace(Chr(10), "<br />")
        Label7.Text = CType(wa(4), DateTime).ToString("yyyy年MM月dd日 dddd HH:mm")
        Label8.Text = wa(0) & " / " & wa(1)
        Image1.ImageUrl = "~/images/weather/" & wa(8)
        Image2.ImageUrl = "~/images/weather/" & wa(9)
        Image3.ImageUrl = "~/images/weather/" & wa(15)
        Image4.ImageUrl = "~/images/weather/" & wa(16)
        Image5.ImageUrl = "~/images/weather/" & wa(20)
        Image6.ImageUrl = "~/images/weather/" & wa(21)
        CityPhoto.ImageUrl = "http://www.cma.gov.cn/tqyb/img/city/" & wa(3)
        CityPhoto.AlternateText = City.SelectedItem.Text

    End Sub

End Class

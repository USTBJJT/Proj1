<%@ Page Language="VB" AutoEventWireup="false" CodeFile="Default.aspx.vb" Inherits="_Default" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <meta name="keywords" content="Weather,WebService,Web,天气,预报,服务," />
    <meta name="description" content="www.webxml.com.cn Weather Forecast WebService" />
    <title>Weather Forecast</title>
    <link href="css/weather.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <form id="form1" runat="server">
        <?xml namespace="" prefix="ajax" ?>
        <ajax:AjaxPanel ID="AJ1" runat="server">
            <table width="680" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                    <td height="60" align="center">
                        <asp:Label Font-Bold="true" ID="Title" runat="server" Text="国内外主要城市  3天天气预报实例" /></td>
                </tr>
                <tr>
                    <td>
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td width="25%">
                                    <strong>选择省/洲</strong>
                                    <asp:DropDownList CssClass="list" ID="Province" runat="server" AutoPostBack="true">
                                    </asp:DropDownList></td>
                                <td>
                                    <strong>选择城市</strong>
                                    <asp:DropDownList CssClass="list" ID="City" runat="server" AutoPostBack="true">
                                    </asp:DropDownList></td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td>
                        <table width="100%" border="0" cellspacing="2" cellpadding="0">
                            <tr>
                                <td width="15%" height="30">&nbsp;                                    </td>
                                <td align="right"><asp:Label CssClass="bredfont" ID="Label8" runat="server" />                                                                    </td>
                            </tr>
                            <tr>
                                <td valign="top">
                                    <strong>今日实况</strong></td>
                                <td class="hfont">
                                    <asp:Label ID="Label1" runat="server" /></td>
                            </tr>
                            <tr>
                                <td valign="top">&nbsp;                                    </td>
                                <td>&nbsp;                                    </td>
                            </tr>
                            <tr>
                                <td valign="top">
                                    <strong>天气预报</strong><font color="#FF0033">(今天)</font></td>
                                <td class="hfont">
                                    <asp:Label ID="Label2" runat="server" />
                                    &nbsp;&nbsp;&nbsp;
                                    <asp:Image AlternateText="icon" ID="Image1" ImageAlign="AbsMiddle" runat="server" />
                                    &nbsp;&nbsp;&nbsp;
                                    <asp:Image AlternateText="icon" ID="Image2" ImageAlign="AbsMiddle" runat="server" /></td>
                            </tr>
                            <tr>
                                <td valign="top">
                                    <strong>今天指数</strong></td>
                                <td>&nbsp;                                    </td>
                            </tr>
                            <tr>
                                <td colspan="2" valign="top" class="hfont">
                                    <asp:Label ID="Label5" runat="server" /></td>
                            </tr>
                            <tr>
                                <td valign="top">&nbsp;                                    </td>
                                <td>&nbsp;                                    </td>
                            </tr>
                            <tr>
                                <td valign="top">
                                    <strong>天气预报</strong><font color="#3333FF">(明天)</font></td>
                                <td class="hfont">
                                    <asp:Label ID="Label3" runat="server" />
                                    &nbsp;&nbsp;&nbsp;
                                    <asp:Image AlternateText="icon" ID="Image3" ImageAlign="AbsMiddle" runat="server" />
                                    &nbsp;&nbsp;&nbsp;
                                    <asp:Image AlternateText="icon" ID="Image4" ImageAlign="AbsMiddle" runat="server" /></td>
                            </tr>
                            <tr>
                                <td valign="top">&nbsp;                                    </td>
                                <td>&nbsp;                                    </td>
                            </tr>
                            <tr>
                                <td valign="top">
                                    <strong>天气预报</strong><font color="#006633">(后天)</font></td>
                                <td class="hfont">
                                    <asp:Label ID="Label4" runat="server" />
                                    &nbsp;&nbsp;&nbsp;
                                    <asp:Image AlternateText="icon" ID="Image5" ImageAlign="AbsMiddle" runat="server" />
                                    &nbsp;&nbsp;&nbsp;
                                    <asp:Image AlternateText="icon" ID="Image6" ImageAlign="AbsMiddle" runat="server" /></td>
                            </tr>
                            <tr>
                                <td valign="top">&nbsp;                                    </td>
                                <td>&nbsp;                                    </td>
                            </tr>
                            <tr>
                                <td colspan="2" valign="top">
                              <strong>城市介绍</strong></td>
                            </tr>
                            <tr>
                                <td colspan="2" valign="top" class="hfont">
                                    <asp:Image CssClass="img" Height="105" ID="CityPhoto" ImageAlign="Left" runat="server"
                                        Width="150" /><asp:Label ID="Label6" runat="server" /></td>
                            </tr>
                            <tr>
                                <td height="30" colspan="2" align="right" valign="bottom">
                                    <strong>预报时间</strong>：
                                    <asp:Label ID="Label7" runat="server" /></td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td height="80">
                        <asp:HyperLink ID="OnHap" runat="server" Text="OnHap WebSite http://www.onhap.com/"
                            Target="_blank" NavigateUrl="http://www.onhap.com/"></asp:HyperLink></td>
                </tr>
            </table>
        </ajax:AjaxPanel>
    </form>
</body>
</html>

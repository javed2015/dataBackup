package com.zeptoh.lynk.dao;

import com.zeptoh.lynk.dao.URLDao;
import com.zeptoh.lynk.model.SelectedContent;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class URLDaoImpl
implements URLDao {
	
	
	public String getResponse(String url1, String lynkType, SelectedContent lynk,
			String context) throws ProtocolException, MalformedURLException,
			IOException {
    Document doc;
        if (!url1.contains("https://") && !url1.contains("http://")) {
            url1 = "http://" + url1;
        }
        URL url2 = new URL(url1);
        URL url = null;
        String q = null;
        if (url2.toString().contains("google") || url2.toString().contains("Google")) {
            if (url2.toString().contains("q=")) {
                int i = url2.toString().indexOf("q=");
                int j = url2.toString().indexOf("&", i);
                j = j == -1 ? url2.toString().length() : j;
                q = url2.toString().substring(i + 2, j);
                q = q.replaceAll("\\+", "%20");
                url = new URL("https://" + url2.getHost() + "/search?q=" + q);
                doc = Jsoup.connect((String)("https://" + url2.getHost() + "/search?q=" + q)).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/30.0.1599.101 Safari/537.36").timeout(10000).get();
            } else {
                doc = Jsoup.connect((String)url1).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/30.0.1599.101 Safari/537.36").timeout(10000).get();
            }
        } else {
            doc = Jsoup.connect((String)url1).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/30.0.1599.101 Safari/537.36").timeout(10000).get();
        }
		String fileName = context.contains("localhost") ? "F:\\"
				+ new SimpleDateFormat("yyyy-MM-dd HH-mm-ss")
						.format(new Date()) + ".html" : "/tmp/"
				+ new SimpleDateFormat("yyyy-MM-dd HH-mm-ss")
						.format(new Date()) + ".html";
        
      /* String fileName = "/tmp/"
				+ new SimpleDateFormat("yyyy-MM-dd HH-mm-ss")
						.format(new Date()) + ".html";*/
		File file = new File(fileName);
        FileUtils.writeStringToFile((File)file, (String)doc.outerHtml(), (String)"UTF-8");
        url = url2;
        String response = this.read(url2, url, doc, context, lynkType, lynk, file, fileName);
        file.delete();
        return response;
    }

    private String read(URL url2, URL url, Document doc, String context, String lynkType, SelectedContent lynk, File file, String fileName) throws IOException {
        String sb;
        Pattern patternHref = Pattern.compile(" href=\"(.*?)\"", 2);
        Pattern patternSrc = Pattern.compile(" src=\"(.*?)\"", 2);
        Pattern patternUrl = Pattern.compile("\\(([^)]+)\\)");
        URL ss = new URL("file:///" + fileName);
        URLConnection connection = ss.openConnection();
    //    System.out.println(connection.getHeaderField("Last-Modified"));
        if (connection.getHeaderField("Last-Modified") == null) {
            String bodyText = doc.toString();
            try {
                String hash = this.makeSHA1Hash(bodyText);
            }
            catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        } else {
     //       System.out.println("No - Last modified");
        }
        InputStream content = connection.getInputStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(content));
        sb = "";
        try {
            String line;
            while ((line = in.readLine()) != null) {
                URL aa1;
                Matcher matcher;
                Matcher matchers1;
                Matcher matcher2;
                URL aa;
                URL aa2;
                String s = line.toString();
                if (s.contains("<head>")) {
                    sb = sb + "<meta charset=\"UTF-8\">";
                    sb = sb + "<script type=\"text/javascript\" src=\"" + context + "/js/jquery.js\"></script>";
                    sb = sb + "<script type=\"text/javascript\" src=\""
							+ context + "/js/fjson.js\"></script>";
                    if (lynkType.equals("load")) {
                        sb = sb + "<script>$(document).ready(function() { window.scroll(0," + lynk.getDummy1() + ")});</script>";
                    }
                    sb = sb + "\n" + s;
                    continue;
                }
                if (s.contains("url(..") || s.contains("url('..") || s.contains("url(\"")) {
                    if (s.contains("data:")) {
                        sb = sb + "\n" + s;
                        continue;
                    }
                    matcher = patternUrl.matcher(s);
                    if (matcher.find()) {
                        aa = new URL(url2, matcher.group(1));
                        s = patternUrl.matcher(s).replaceAll("(" + aa + ")");
                        sb = sb + "\n" + s;
                        continue;
                    }
                    sb = sb + "\n" + s;
                    continue;
                }
                if (s.contains("</body>")) {
                	 sb = sb + "<script type=\"text/javascript\" src=\"" + context + "/js/classie.js\"></script>";
                     sb = sb + "<script type=\"text/javascript\" src=\"" + context + "/js/sort1.js\"></script>";
                     sb = sb + "\n" + s;
                	 if (lynkType.equals("generate")) {
 	                    sb = sb + "<script type=\"text/javascript\" src=\"" + context + "/js/modalEffects.js\"></script>";
 	                    //sb = sb + "<script type=\"text/javascript\" src=\"" + context + "/js/script.js\"></script>";
 	                    sb = sb + "<script type=\"text/javascript\" src=\"" + context + "/js/factualnote_script.js\"></script>";
 	                }else{
                	 sb = sb + "<script type=\"text/javascript\">" 
							 +"var lynked_Urlcont = '<div class=\"lynked-url\" style=\"position:fixed; top:0; width:100%; margin:auto; background-color:rgba(10, 26, 52, 0.7); font-size:12px; heigth:24px; padding:10px; z-index: 999995;\" > </div>';"  
						 	 +"var lynked_Urlbox = '<div style=\"background-color:white; color:black; margin:auto; font-size:14px; width:90%; border:1px solid #0099FF; padding:4px 10px;\">"+url+"</div>';"
						 	 +"$('#lytop').prepend(lynked_Urlcont);"
						 	 +"$('.lynked-url').append(lynked_Urlbox);"										
						 	 +"$('#lydata').css({'position':'relative','top':'44px'});"
						 	 +"$('header').css({'position':'relative','top':'44px'});"
						 	 +"</script>";
 	                }
                     sb = sb + "</div>";
                     sb = sb + "</div>";
                }
                if (s.contains("<body")) {
                    if (lynkType.equals("generate")) {
                        sb = sb + "\n" + s;
                        sb = sb + "<div id =\"lytop\" class=\"container-fluid\">";
                        sb = sb + "<div id =\"lydata\" class=\"container-fluid lynked-cnt-down\">";
                        sb = sb + "<script type=\"text/javascript\" src=\"" + context + "/js/editor.js\"></script>";
                        sb = sb + "<input type = \"hidden\" id = \"lynk_url\" name = \"lynk_url\" value = \"" + url + "\" />";
                        sb = sb + "<input type = \"hidden\" id = \"lynk_dummy1\" name = \"lynk_dummy1\" value = \"dummy1\" />";
                        sb = sb + "<input type = \"hidden\" id = \"lynk_dummy2\" name = \"lynk_dummy2\" value = \"dummy2\" />";
                        sb = sb + "<input type = \"hidden\" id = \"lynk_context\" name = \"lynk_context\" value = \"" + context + "\" />";
                        continue;
                    }
                    sb = sb + "<body onload =\" refresh() \" >";
                    sb = sb + "<div id =\"lytop\" class=\"container-fluid\">";
                    sb = sb + "<div id =\"lydata\" class=\"container-fluid\">";
                    sb = sb + "<input type = \"hidden\" id = \"lynk_data\" name = \"lynk_data\" value = " + lynk.getData() + " />";
                    sb = sb + "<input type = \"hidden\" id = \"lynk_url\" name = \"lynk_url\" value = \"" + url + "\" />";
                    sb = sb
							+ "<style>"
							+ ".rcorners11 {border: none;}"
							+ ".rcorners12 {border: 1px solid #fff;background-clip: padding-box;border-radius: 4px;box-shadow: 0px 0px 8px 0px #000;}"
							+ "</style>";
                    sb = sb + "<input type = \"hidden\" id = \"lynk_dummy1\" name = \"lynk_dummy1\" value = " + lynk.getDummy1() + " />";
                    sb = sb + "<input type = \"hidden\" id = \"lynk_dummy2\" name = \"lynk_dummy2\" value = " + lynk.getDummy2() + " />";
                    sb = sb + "<input type = \"hidden\" id = \"lynk_context\" name = \"lynk_context\" value = \"" + context + "\" />";
                    continue;
                }
                if (s.contains("type=\"text/css\"") || s.contains("rel='stylesheet'") || s.contains("rel=\"stylesheet\"") || s.contains("rel='Stylesheet'") || s.contains("rel=\"Stylesheet\"")) {
                    matcher = patternHref.matcher(s);
                    if (matcher.find()) {
                        aa = new URL(url2, matcher.group(1));
                        s = patternHref.matcher(s).replaceAll(" href=\"" + aa + "\"");
                        sb = sb + "\n" + s;
                        continue;
                    }
                    sb = sb + "\n" + s;
                    continue;
                }
                if (s.contains("<script ")) {
                    if (s.contains("src=")) {
                        matcher = patternSrc.matcher(s);
                        if (matcher.find()) {
                            if (matcher.group(1).contains("data") || matcher.group(1).contains("void")) {
                                sb = sb + "\n" + s;
                                continue;
                            }
                            aa = new URL(url2, matcher.group(1));
                            s = patternSrc.matcher(s).replaceAll(" src=\"" + aa + "\"");
                            sb = sb + "\n" + s;
                            continue;
                        }
                        sb = sb + "\n" + s;
                        continue;
                    }
                    sb = sb + "\n" + s;
                    continue;
                }
                if (s.contains("<img ") && s.contains("<a href")) {
                    matchers1 = patternSrc.matcher(s = s.replaceAll("'", "\""));
                    if (matchers1.find()) {
						if (matchers1.group(1).contains("data")
								|| matchers1.group(1).contains("javascript")
								|| matchers1.group(1).contains("tel")
								|| matchers1.group(1).contains("void")
								|| matchers1.group(1).contains("about")) {
							aa1 = new URL(url2, matchers1.group(1));
							s = patternSrc.matcher(s).replaceAll(
									" src=\"" + aa1 + "\"");
						}
					}
                    if ((matcher2 = patternHref.matcher(s)).find()) {
                        if (matcher2.group(1).contains("data") || matcher2.group(1).contains("javascript")
                        		||matcher2.group(1).contains("tel") || matcher2.group(1).contains("void") || matcher2.group(1).contains("about")) {
                            sb = sb + "\n" + s;
                            continue;
                        }
                        aa2 = new URL(url2, matcher2.group(1));
                        s = patternHref.matcher(s).replaceAll(" href=\"" + aa2 + "\"");
                        sb = sb + "\n" + s;
                        continue;
                    }
                    sb = sb + "\n" + s;
                    continue;
                }
                if (s.contains("<img ") || s.contains("<iframe ") || s.contains("src=")) {
					s = s.replaceAll("data-src=\"/", "data-src=\"http://"
							+ url.getHost() + "/");
			//		System.out.println(s);
					matchers1 = patternSrc.matcher(s);
                    if (matchers1.find()) {
                        if (matchers1.group(1).contains("data")|| matchers1.group(1).contains("tel")|| matchers1.group(1).contains("javascript")
								|| matchers1.group(1).contains("void")|| matchers1.group(1).contains("about")) {
						    sb = sb + "\n" + s;
                            continue;
                        }
                        aa1 = new URL(url2, matchers1.group(1));
                        s = patternSrc.matcher(s).replaceAll(" src=\"" + aa1 + "\"");
                        sb = sb + "\n" + s;
                        continue;
                    }
                    sb = sb + "\n" + s;
                    continue;
                }
                if (s.contains("rel=\"shortcut icon\"") || s.contains("rel=\"icon\"")) {
                    matchers1 = patternSrc.matcher(s);
                    if (matchers1.find()) {
                        if (matchers1.group(1).contains("data") || matchers1.group(1).contains("void")) {
                            sb = sb + "\n" + s;
                        } else {
                            aa1 = new URL(url2, matchers1.group(1));
                            s = patternSrc.matcher(s).replaceAll(" src=\"" + aa1 + "\"");
                        }
                    }
                    if (!(matcher2 = patternHref.matcher(s)).find()) continue;
                    if (matcher2.group(1).contains("data") || matcher2.group(1).contains("void")) {
                        sb = sb + "\n" + s;
                        continue;
                    }
                    aa2 = new URL(url2, matcher2.group(1));
                    s = patternHref.matcher(s).replaceAll(" href=\"" + aa2 + "\"");
                    sb = sb + "\n" + s;
                    continue;
                }
                if (s.contains("param name=\"movie\"") || s.contains("param name='movie'")) {
                    if ((s = s.replace("'", "\"")).contains("value=\"http")) {
                        sb = sb + "\n" + s;
                        continue;
                    }
                    s = s.replace("value=\"", "value=\"http://" + url.getHost() + "/");
                    sb = sb + "\n" + s;
                    continue;
                }
                if (s.contains("<embed ")) {
                    matchers1 = patternSrc.matcher(s);
                    if (!matchers1.find()) continue;
                    aa1 = new URL(url2, matchers1.group(1));
                    s = patternSrc.matcher(s).replaceAll(" src=\"" + aa1 + "\"");
                    sb = sb + "\n" + s;
                    continue;
                }
                if (s.contains("<a ")) {
                    s = s.replaceAll("'", "\"");
                    s = s.replaceAll("data-bgimg=\"/", "data-bgimg=\"http://" + url.getHost() + "/");
                    matcher = patternHref.matcher(s = s.replaceAll("data-bgimg2x=\"/", "data-bgimg=\"http://" + url.getHost() + "/"));
                    if (matcher.find()) {
                        if (matcher.group(1).contains("data")|| matcher.group(1).contains("tel")|| matcher.group(1).contains("javascript")
								|| matcher.group(1).contains("void")|| matcher.group(1).contains("about"))  {
							sb = sb + "\n" + s;
                            continue;
                        }
                        aa = new URL(url2, matcher.group(1));
                        s = patternHref.matcher(s).replaceAll(" href=\"" + aa + "\"");
                        sb = sb + "\n" + s;
                        continue;
                    }
                    sb = sb + "\n" + s;
                    continue;
                }
				s = s.replaceAll("data-bgimg='/", "data-bgimg='http://"
						+ url.getHost() + "/");
				s = s.replaceAll("data-bgimg2x='/", "data-bgimg='http://"
						+ url.getHost() + "/");
				s = s.replaceAll("data-bgimg=\"/", "data-bgimg=\"http://"
						+ url.getHost() + "/");
				s = s.replaceAll("data-bgimg2x=\"/", "data-bgimg=\"http://"
						+ url.getHost() + "/");
				s = s.replace("url('/", "url('http://" + url.getHost() + "/");
				s = s.replace("url(/", "url(http://" + url.getHost() + "/");
                s = s.replace("url(//", "url(http://");
                s = s.replace("url(../../", "url(http://" + url.getHost() + "/");
                s = s.replace("url(../", "url(http://" + url.getHost() + "/");
                s = s.replace("\"../", "\"http://" + url.getHost() + "/");
                sb = sb + "\n" + s;
            }
        }
        finally {
            in.close();
        }
        return sb;
    }

    public String makeSHA1Hash(String bodyText) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("SHA1");
        md.reset();
        byte[] buffer = bodyText.getBytes("UTF-8");
        md.update(buffer);
        byte[] digest = md.digest();
        String hexStr = "";
        for (int i = 0; i < digest.length; ++i) {
            hexStr = hexStr + Integer.toString((digest[i] & 255) + 256, 16).substring(1);
        }
        return hexStr;
    }

	
	
	
}

const SERIES_KEY = "series";
const SEASON_KEY = "season";
const TITLE_KEY = "title_series";

var localStorage = window.localStorage;

var currentSeries = localStorage.getItem(SERIES_KEY);  // Структура
var currentSeason = localStorage.getItem(SEASON_KEY);
var currentTitle = localStorage.getItem(TITLE_KEY);

var seasonSize = document.querySelector('#data_season').value;

if((currentSeason == null) && (currentSeries == null)){
    localStorage.setItem(SERIES_KEY, 1);
    localStorage.setItem(SEASON_KEY, 1);
    localStorage.setItem(TITLE_KEY, "01. За что наказали кота");

    currentSeries = localStorage.getItem(SERIES_KEY);
    currentSeason = localStorage.getItem(SEASON_KEY);
    currentTitle = localStorage.getItem(TITLE_KEY);
}

document.getElementById("name-series_title").innerHTML = currentTitle;
document.getElementById("name-series_title").innerHTML = currentTitle;
document.getElementById("video-player").src = `video/${currentSeason}/${currentSeries}`;
document.getElementsByClassName("series_button")[currentSeries-1].style.color = "#b4ff93";
document.getElementsByClassName("change_season_btn")[currentSeason-1].style.background = "#b4ff93";
document.getElementsByClassName("series_btn-season_attr").innerHTML = currentSeason;

var backBtn = document.getElementById("btn-back");
var nextBtn = document.getElementById("btn-next");

checkFirstSeries();
checkLastSeries();

function checkFirstSeries(){
    if (currentSeries == 1) {
        document.getElementById("btn-back").disabled = true;
        document.getElementById("btn-back").style.opacity = 0;
    }
}

function checkLastSeries(){
    if (currentSeries == seasonSize) {
        document.getElementById("btn-next").disabled = true;
        document.getElementById("btn-next").style.opacity = 0;
    }
}

function selectSeries(series){
    localStorage.setItem(TITLE_KEY, series.description);
    localStorage.setItem(SERIES_KEY, series.pos);
    return false;
}

function selectSeason(season) {
    localStorage.setItem(SEASON_KEY, season.number);
    localStorage.setItem(SERIES_KEY, 1);
    localStorage.setItem(TITLE_KEY, season.seriesList[localStorage.getItem(SERIES_KEY)-1].description);
}

function clickNextBtn(allMovies){
     var curr = allMovies[currentSeason-1].seriesList[currentSeries];
     localStorage.setItem(SERIES_KEY, parseInt(currentSeries) + 1);
     localStorage.setItem(TITLE_KEY, curr.description);
     localStorage.setItem(SEASON_KEY, curr.season_id);
}

function clickBackBtn(allMovies){
     var curr = allMovies[currentSeason-1].seriesList[currentSeries];
     localStorage.setItem(SERIES_KEY, parseInt(currentSeries) - 1);
     localStorage.setItem(TITLE_KEY, allMovies[currentSeason-1].seriesList[currentSeries-2].description);
     localStorage.setItem(SEASON_KEY, curr.season_id);
}

//function getNameSeries(season, series) {
//    var str;
//    fetch('http://localhost:8080/movie/' + season + "/" + series)
//      .then((response) => {
//        return response.json();
//      })
//      .then((data) => {
//        console.log(data);
//        localStorage.setItem(MOVIE_KEY, data);
//        str = data.name;
//      });
//      return str;
//}

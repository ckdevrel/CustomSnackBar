[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-CustomSnackBar-green.svg?style=flat)](https://android-arsenal.com/details/1/2659)

<a href='https://ko-fi.com/A302HW7' target='_blank'><img height='36' style='border:0px;height:36px;' src='https://az743702.vo.msecnd.net/cdn/kofi4.png?v=f' border='0' alt='Buy Me a Coffee at ko-fi.com' /></a> 

CustomSnackBar
--------------

CustomSnackBar is a repo of my own customization for Snackbar, with this you could able to change background color of Snackbar, font, style, color, icons for title and action. The Snackbar usage in android application is completely customized according to the Singleton pattern methods for using Snackbar effectively in Activity and fragments by avoiding un necessary object creation and lengthy boiler plate code.


<a href="http://imgur.com/V5fc9j1"><img src="http://i.imgur.com/V5fc9j1.gif" title="source: imgur.com" /></a>

How to use?
-----------

**To create Simple Snackbar with Title and Action text** 
```
 SnackBar snackBar = new SnackBar();
        snackBar.view (view)
                .text ("title", "action")
                .show ();
```
**Note:** By creating simple Snackbar, your text color will be white and action color will be yellow by default with black background.

**To customize Color of Title and Action Text**

```
 SnackBar snackBar = new SnackBar();
        snackBar.view (view)
                .text ("title", "action")
                .textColors (Color.WHITE,Color.RED)
				.show ();
```

**Tip:**  You can pass your desired color codes in to 
`textColors(Color.WHITE,Color.RED)`. 

**To customize background Color of Snackbar**

```
 SnackBar snackBar = new SnackBar();
        snackBar.view (view)
                .text ("title", "action")
                .backgroundColor (Color.RED)
				.show ();
```
**Tip:**  You can pass your desired color codes as background in 
`backgroundColor(Color.RED)`. 

**To Change duration of Snackbar to be displayed**

```
 SnackBar snackBar = new SnackBar();
        snackBar.view (view)
                .text ("title", "action")
                .duration (SnackBar.SnackBarDuration.LONG)
				.show ();
```
**Types of duration:**

 1. ` SnackBar.SnackBarDuration.SHORT` - Displays Snackbar for short duration
 
 2. ` SnackBar.SnackBarDuration.LONG` - Displays Snackbar for long duration
 
 3. ` SnackBar.SnackBarDuration.INDEFINITE` - Snackbar disappears only if you Click Action button. This case can be used for handling any click events in a Action button ( i.e Calling any methods or changing UI's ).
 
**Tip:**  If you fail to assign your duration, by default **SHORT** duration will be assigned.

**To Handle click events in Action button**

```
   SnackBar snackBarActionClick = new SnackBar();
        snackBarActionClick.view(mainContent)
          .text ("Error fetching data", "RETRY")
          .duration (SnackBar.SnackBarDuration.INDEFINITE)
          .setOnClickListener (true, new            OnActionClickListener () {
                    @Override
                    public void onClick (View view) {
                        //Do your stuffs here.

                    }
                })
                .show ();
```
**Note:**  Here I have specified Snackbar duration as 
`SnackBar.SnackBarDuration.INDEFINITE` because to perform some actions in `onClick`

Why to use CustomSnackbar?
--------------------------

1. It is a better replacement for Toast, Dialogs, Alert, etc.,

2. More than that it is easy to use and enrich the User experience by easy customization through Singleton pattern.

3. It is easy to use in Activity or Fragment.  

> **Note:** All the above customizations are clearly explained in this sample code.  Download the zip and play with Snackbar's. 

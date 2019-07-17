# Optimization project

![img perfomase project](https://i.ibb.co/ZW5cTPR/108.png)


My first project to java language. He helps people who write code to html, css, php. Dream everyone web-developers. You can write your plugin for need program language. It's easy.


## Run application (files to dist folder)
#### Case 1 (Windows, Linux, MacOS):
Check java virtual machine. Command to console:
```
java -version
```
If have then run java class. Command to console:
```
java -jre Optimization_project.class
```
#### Case: 2 (Windows)
double click to run_app.cmd

------------

## Write plugin
- Check java class **Example.java** *(src/oprimization/project/optimization/Example.java)* - it's basic class language filter. Read comments and write code to special methods. You can see other class and get experience. Good luck.
- When your class finish state you can include  him to application. Open file **ScanFolder.java** *(src/optimization/project/ScanFolder)* and find method **optimizationFiles**. Select type file and set filter.

**Example:**
```java
    private void optimizationFiles() throws IOException{
        
        this.setValueProgressBar(70);
        
        for (Map.Entry entry : this.absolutePathToFiles.entrySet()) {
            
            String type = this.getFileExtension(new File(entry.getKey().toString()));
            String pathResult = this.pathResult + entry.getValue().toString();
            String pathSource = entry.getKey().toString();
            
            // print filePath to console
            this.cnslPrint(pathSource, Color.LIGHT_GRAY);
            
            switch (type){
                case "your_type_file":
                    ClassYourFiler filter = new ClassYourFiler filter();
                    filter.setPathSource(pathSource);
                    filter.setPathResult(pathResult);
                    filter.run();
                    break;
                case "html":
                    HTML html = new HTML();
                    html.setPathSource(pathSource);
                    html.setPathResult(pathResult);
                    html.run();
                    break;
                case "php":
                    PHP php = new PHP();
                    php.setPathSource(pathSource);
                    php.setPathResult(pathResult);
                    php.run();
                    break;
                case "js":
                    JavaScript js = new JavaScript();
                    js.setPathSource(pathSource);
                    js.setPathResult(pathResult);
                    js.run();
                    break;
                case "json":
                    JSON json = new JSON();
                    json.setPathSource(pathSource);
                    json.setPathResult(pathResult);
                    json.run();
                    break;
                case "css":
                    CSS css = new CSS();
                    css.setPathSource(pathSource);
                    css.setPathResult(pathResult);
                    css.run();
                    break
                default:
                    Other other = new Other();
                    other.setPathSource(pathSource);
                    other.setPathResult(pathResult);
                    other.run();
            }
        }
        
        this.setValueProgressBar(100);
    }
```

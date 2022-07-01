## These are the most important Commands Of Git

```
git init
git config --global user.name "Arash Samandar"
git config --global user.email "arash.internet@gmail.com"
git add .   (or the name of the file)
git commit -m "hello this is the first commit"
git log     (shows all the logs that has made during commit)
git help log
git log -n 2  (just show two logs)
git log --since=2012-06-15  (look by the time which commits where done)
git log --until=2012-06-14   (you can use it with above command)
git log --author="Arash"    (see what Arash has done)
git log --grep="init"   (searches for any commit with "init" in its message)
git diff --staged
git log --oneline  (shows all the commits and minimizes the hash) veryyy useful .
git restore --staged file2.js  ( this would take it out from the stage)

git reset HEAD filename.txt ( puts it in working environment and out of the staging environment)

git rm file.html

git add --all ( adds all the files including deletions and other things)

git status

git branch   (lists all the branchs)

git checkout master

git branch app01  (to create a new branch)

git branch -m app01 app1  (to change the name of the branch)

git merge app01   (merges it to master , and brings the changes from the app01 to the master)

git branch -D alternate  (removes the branch named Alternate)

git branch <new-branch-name> 23d234  (to create and name the branch you just brought in from the logs hashes)

git clone --mirror https://address..../arash.git .git (it gets the project and all of its branches)

git checkout -b 02_01 origin/02_01  (not important)

git clone -b 00_start https://asdgasgd/asdfasf.git  (Important ! MOHEM agar ye roozi mikhay maale khodet ro clone koni (yeki az branch haa ro copy koni va edame bedi az roosh))

```

![image-20210519213902188](D:\Programming Notes\GIT.assets\image-20210519213902188.png)

## If you want to push your repository to the GitHub

```
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin git@github.com:arashsamandar/Delete-Me.git
git push -u origin main
```

## …or push an existing repository from the command line

```
git remote add origin git@github.com:arashsamandar/Delete-Me.git
git branch -M main
git push -u origin main
```

## SSH

> with `SSH Keys` , with ssh keys you don't have to enter __password__ any more :star:

> you may create `ssh keys` in `github`

> with phpstorm you can also create ssh keys to be connected directly to the `server`

## Github

```markdown
git push // you can use git pull to get a repository
git clone // to copy a remote repository into your current folder
```

```
git add . // to add everything in current folder(project)
git commit -m 'i am arash'
```

### .gitignore

> to ignore some files from commiting use :`gitignore` , if this file doesn't exist , make one yourself

> type the file name that you don't want to `git add` , write the file name and extention to the `.gitignore`

```
git add . // now that file wouldn't be included .
```

## exclude from git add and commit

> use the `.gitignore` , write the file name in it .

> to exclude a `folder` type the name with a slash , just like bellow

```
// inside .gitignore
/myfolder
```

> use *.txt to include all text files and as such

## branch

> use `git branch arash_project` , now __arash_project__ is a branch

> use `git checkout arash_project` , to go to the branch

> create a branch with `git branch arash` , now arash is a branch

> to go to a branch type `git checkout arash` , ( now we are in the arash branch )

### important

> when you are in the __arash__ branch , go on and create a file with `touch`.

```markdown
> git branch arash // still in the __master__ branch
> git checkout arash // now in the __arash__ branch

> touch index.html // creates a file index.html while in the arash branch
> git add .
> git commit -m 'login form'

IMPORTANT
	if you come out , out of the branch with __ git checkout master __
	the login would not be there
	
	add the login.html which is in the __ arash branch __ 
	with
> git merge arash

IMPORTANT

	// now the login.html would appear .

```

## Github integration

> first type

```markdown
> git commit -m 'my message'
> git remote
> git remote add origin https://github.com/arashsamandar/ArashGitTest.git
	// use any other address neccessary
> git push -u origin master
```

> :star:> Remember first to `git commit -m 'your message'` .
>
> :star:  You must first commit what you want to __push__

#### Note

> once you provided the __credentials__ , you don't need them any more
>
> push to the __online repository__ just with :

```
git push
```

## github clone

```markdown
> git clone https://github/theAddress
```

> once you do `git clone http://theAddress` , for the other times you don't need to enter the address
>
> just type bellow command , using `pull` command .

```markdown
git pull
```

## I have an error

> do bellow :

```
git push --set-upstream origin main
```

### Remove a URL or git remote 

```javascript
git remote -v   // to see current remotes
//---------------------
git remote rm destination // to remove the current remote
//---------------------
// then you can add new one with :
git remote add origin theURL
//---------------------
git push
//---------------------
fatal: The current branch main has no upstream branch.
To push the current branch and set the remote as upstream
// if you had not any upstream use bellow code :
git push --set-upstream origin main
//-----------------------

```


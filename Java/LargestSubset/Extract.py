f = open('./input.txt','r')
txt = f.readline()
f.close()
out = txt.split(',')

for i in range(0,len(out)):
	out[i] = int(out[i])

##out.sort()

for i in out:
	print i

